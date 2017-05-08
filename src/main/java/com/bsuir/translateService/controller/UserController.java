package com.bsuir.translateService.controller;

import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Олег Пятко on 07.05.2017.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserEntity>> findAllUsers(){
       //ModelAndView modelAndView = new ModelAndView("index");
        //modelAndView.addObject("users",userService.findAll());
        Iterable<UserEntity> users = userService.findAll();
        return new ResponseEntity<Iterable<UserEntity>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users_id", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findUserById(){
        //ModelAndView modelAndView = new ModelAndView("index");
        //modelAndView.addObject("users",userService.findAll());
        UserEntity users = userService.findById(1);
        return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users_login", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findUserByLogin(){
        //ModelAndView modelAndView = new ModelAndView("index");
        //modelAndView.addObject("users",userService.findAll());
        UserEntity users = userService.findByLogin("user");
        return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users_email", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findUserByEmail(){
        //ModelAndView modelAndView = new ModelAndView("index");
        //modelAndView.addObject("users",userService.findAll());
        UserEntity users = userService.findByEmail("user@gmail.com");
        return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users_create", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> createUser(){
        //ModelAndView modelAndView = new ModelAndView("index");
        //modelAndView.addObject("users",userService.findAll());
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin("new_user");
        userEntity.setEmail("new_email@gmail.com");
        userEntity.setRole("user");
        userEntity.setAbout("");
        userEntity.setPasswordHash("sdfsgdsher7834f");
        UserEntity users = userService.createUser(userEntity);
        return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
