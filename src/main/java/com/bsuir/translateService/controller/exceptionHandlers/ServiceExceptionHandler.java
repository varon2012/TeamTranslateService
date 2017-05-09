package com.bsuir.translateService.controller.exceptionHandlers;

import com.bsuir.translateService.service.exception.ServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value =  {ServiceException.class})
    protected ResponseEntity<Object> handleServiceConflict(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        if(bodyOfResponse == null) {
            bodyOfResponse = "BadRequest";
        }
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
