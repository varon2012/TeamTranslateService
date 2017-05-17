package com.bsuir.translateService.controller;

import com.bsuir.translateService.entity.LoginEntity;
import com.bsuir.translateService.entity.RoleEnum;
import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.security.GetTokenService;
import com.bsuir.translateService.service.UserService;
import com.bsuir.translateService.service.exception.ServiceException;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Олег Пятко on 07.05.2017.
 */

@CrossOrigin
@RestController
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        LoginEntity loginEntity = new LoginEntity();
        modelAndView.addObject("loginEntity", loginEntity);
        return modelAndView;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView reg(){
        LoginEntity loginEntity = new LoginEntity();
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("login", loginEntity);
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request, LoginEntity loginEntity){
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(loginEntity.getUsername());
        userEntity.setPasswordHash(loginEntity.getPassword());
        userEntity.setRole(RoleEnum.USER);
        userEntity.setEmail(loginEntity.getEmail());
        userService.createUser(userEntity);
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        return modelAndView;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ModelAndView goToMainPage(HttpServletRequest request, LoginEntity loginEntity) throws Exception {
       /* if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }*/
        String login = loginEntity.getUsername();
        String password = loginEntity.getPassword();
        UserEntity userEntity = userService.findByLogin(login);
        if (userEntity != null){
            String token = getTokenService.getToken(login, password);
            if (token != null){
                request.getSession().setAttribute("token", token);
            }
            else {
                return new ModelAndView("login");
            }
        }
        return new ModelAndView("redirect:/users");
    }

    @Autowired
    private GetTokenService getTokenService;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    /*
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserEntity>> findAllUsers(){
        Iterable<UserEntity> users = userService.findAll();
        return new ResponseEntity<Iterable<UserEntity>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findUserById(@PathVariable(value = "id")int id){
        UserEntity users = userService.findById(id);
        return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }

        @RequestMapping(value = "/user/{login}", method = RequestMethod.GET)
        public ResponseEntity<UserEntity> findUserByLogin(@PathVariable(value = "login")String login){
            UserEntity users = userService.findByLogin(login);
            return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
        }

        @RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
        public ResponseEntity<UserEntity> findUserByEmail(@PathVariable(value = "email")String email){
            UserEntity users = userService.findByEmail(email);
            return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
        }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        UserEntity users = userService.createUser(userEntity);
        return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete_user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable(value = "id") int id){
        userService.deleteUser(id);
        return new ResponseEntity( HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity){
        userService.updateUser(userEntity);
        UserEntity updatedUser = userService.findByLogin(userEntity.getLogin());
        return new ResponseEntity<UserEntity>(updatedUser, HttpStatus.OK);
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/
}
