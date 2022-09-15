package com.ssmp.utils;

import com.ssmp.pojo.Employee;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static Employee getEmployee(){
        Employee employee = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes != null){
            HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
            // Do something
            employee = (Employee) session.getAttribute("employee");
        }
        return employee;
    }
    public static HttpSession getSession(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes != null) {
            HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
            return session;
        }
        return null;
    }
}
