package com.bsuir.translateService.security;

import com.bsuir.translateService.entity.RoleEnum;
import com.bsuir.translateService.entity.UserEntity;
import javassist.bytecode.SignatureAttribute;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
/**
 * Created by Олег Пятко on 15.05.2017.
 */
@Aspect
@Component
public class SecureBeforeMethod {

    @Around("@annotation(com.bsuir.translateService)")
    public ResponseEntity doSecure(ProceedingJoinPoint joinPoint) throws Throwable {
        SignatureAttribute.MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        RoleEnum[] validRoles = method.getAnnotation(Secured.class).value();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if(request != null) {
            UserEntity currentUser = ((UserEntity) (request).getAttribute("user"));
            if (currentUser != null) {
                if (validRoles.length == 0) {
                    return (ResponseEntity) joinPoint.proceed();
                }
                if (validateRole(validRoles, currentUser.getRole())) {
                    return (ResponseEntity) joinPoint.proceed();
                }
            }
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


    private boolean validateRole(RoleEnum[] roles,RoleEnum role) {
        for (RoleEnum validRole: roles) {
            if (validRole == role) {
                return true;
            }
        }
        return false;
    }

}
