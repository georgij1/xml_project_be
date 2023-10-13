package com.xml_project_be.xml_project.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Aspect
@Component
public class CheckHeaderAspect {
    @Autowired
    HttpServletRequest request;
    Logger logger = Logger.getLogger("");


    @Around("@within(CheckHeader) || @annotation(CheckHeader)")
    public Object check_header(ProceedingJoinPoint joinPoint) throws Throwable {
        if (request.getHeader("Authorization") != null
                &&
                request.getHeader("Authorization").startsWith("Bearer ")
        ) {
            logger.info("you have jwt token");
            return joinPoint.proceed();
        }

        else {
            logger.info("you haven't got jwt token");
            return "you haven't got jwt token";
        }
    }
}