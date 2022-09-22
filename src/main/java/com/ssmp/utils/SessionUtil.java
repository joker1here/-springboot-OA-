package com.ssmp.utils;

import com.ssmp.pojo.Employee;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static Employee getEmployee(){
        HttpSession session = getSession();
        if (session!=null) {
            return (Employee) session.getAttribute("employee");
        }
        return null;
    }
    public static HttpSession getSession(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes != null) {
            return (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        }
        return null;
    }
}
