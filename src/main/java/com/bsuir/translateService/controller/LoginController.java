package com.bsuir.translateService.controller;

import com.bsuir.translateService.dto.LoginEntity;
import com.bsuir.translateService.entity.RoleEnum;
import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.security.GetTokenService;
import com.bsuir.translateService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class LoginController extends BaseController{
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
        return new ModelAndView("redirect:/branch_list/");
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request){
        request.getSession().removeAttribute("token");
        LoginEntity loginEntity = new LoginEntity();
        return BuildModelAndView("login", "loginEntity", loginEntity);
    }

    @Autowired
    private GetTokenService getTokenService;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
