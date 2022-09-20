package com.ssmp.config;

import com.ssmp.pojo.Employee;
import com.ssmp.utils.Result;
import com.ssmp.utils.SessionUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aop {
    //切点在除登陆外的所有控制器
    @Pointcut("execution(* com.ssmp.controller.*.*(..)) " +
            "&& !execution(* com.ssmp.controller.LoginController.*(..))")
    public void pc1() {
    }
    /**
     * 使用环绕增强器实现拦截器功能
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //判断是否登陆
        Employee employee = SessionUtil.getEmployee();
        if (employee==null){
            System.out.println("没有登录！");
            return Result.fail("没有登录！");
        }
        //判断方法有无异常
        try{
            //运行原方法
            return pjp.proceed();
        }catch ( Exception e){
            System.out.println("数据库异常："+e);
            return Result.fail("数据库错误！");
        }
    }

//    @Before(value = "pc1()")
//    public void before(JoinPoint jp) {
//        String name = jp.getSignature().getName();
//
//        System.out.println(name + "方法开始执行...");
//        Employee employee = SessionUtil.getEmployee();
//        System.out.println("session:"+employee);
//    }

//    @After(value = "pc1()")
//    public void after(JoinPoint jp) {
//        String name = jp.getSignature().getName();
//        System.out.println(name + "方法执行结束...");
//    }
//
//    @AfterReturning(value = "pc1()", returning = "result")
//    public void afterReturning(JoinPoint jp, Object result) {
//        String name = jp.getSignature().getName();
//        System.out.println(name + "方法返回值为: " + result);
//    }
//
//    @AfterThrowing(value = "pc1 ()", throwing = "e")
//    public void afterThrowing(JoinPoint jp, Exception e) {
//        String name = jp.getSignature().getName();
//        System.out.println(name + "方法抛异常了，异常是: " + e.getMessage());
//    }
//

}
