package com.bsuir.translateService.security;

import com.bsuir.translateService.entity.RoleEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Олег Пятко on 14.05.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Secured {
    RoleEnum[] value();
}