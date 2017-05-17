package com.bsuir.translateService.interceptor;

import com.bsuir.translateService.entity.RoleEnum;
import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.security.GetTokenService;
import com.bsuir.translateService.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Олег Пятко on 16.05.2017.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private GetTokenService getTokenService;

    private  int ADMIN = 0;
    private  int USER = 1;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = (String) request.getSession().getAttribute("token");

        if (!request.getRequestURI().equals("/login") &&
                !request.getRequestURI().equals("/register")&&
                !request.getRequestURI().equals("/auth")&&
                !request.getRequestURI().equals("/reg")){
            Claims claims;

            if(token != null) {
                try {
                    String login = getTokenService.getLoginFromToken(token);

                    UserEntity userEntity =  userService.findByLogin(login);
                    if((userEntity == null))
                    {
                        response.sendRedirect("/login");
                        return false;
                    }
                    String tokenToCompare = getTokenService.getToken(userEntity.getLogin(), userEntity.getPasswordHash());
                    if(tokenToCompare.equals(token))
                    {
                        int role = userEntity.getRole().getValue();
                        if((role == 0)  || (role == 1)){
                            return true;
                        }
                        else{
                            response.sendRedirect("/login");
                            return false;
                        }
                    }
                    else
                    {
                        response.sendRedirect("/login");
                        return false;
                    }
                }
                catch (Exception ex)
                {
                    throw new Exception("Token corrupted");
                }
            }
            else
            {
                response.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }
}