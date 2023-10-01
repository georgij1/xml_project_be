package com.xml_project_be.xml_project.aop;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
public class CheckHeaderAspect {
    HttpServletRequest request;
    HttpServletResponse response;

    @Around("@within(CheckHeader) || @annotation(CheckHeader)")
    public Object check_header(ProceedingJoinPoint joinPoint) throws Throwable {
        if (request.getHeader("Authorization") != null
                &&
                request.getHeader("Authorization").startsWith("Bearer ")
        ) {
            return joinPoint.proceed();
        }

        else {
            System.out.println("you have not got jwt token");
            return "you have not got jwt token";
        }
    }
}