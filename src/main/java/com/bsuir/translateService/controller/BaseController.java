package com.bsuir.translateService.controller;

import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.security.GetTokenService;
import com.bsuir.translateService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Олег Пятко on 17.05.2017.
 */
public abstract class BaseController {
    public ModelAndView BuildModelAndView(String view, String attribute, Object model){
        return new ModelAndView(view, attribute, model);
    }

    public ModelAndView BuildModelAndView(String view){
        return new ModelAndView(view);
    }

    public UserEntity getUserEntityFromToken(HttpServletRequest request){
        String token = (String)request.getSession().getAttribute("token");
        if (token != null){
            try{
                int userId = getTokenService.getIdFromToken(token);
                UserEntity userEntity = userService.findById(userId);
                return  userEntity;
            }
            catch (Exception ex){
                return null;
            }
        }
        return null;
    }

    @Autowired
    private GetTokenService getTokenService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
