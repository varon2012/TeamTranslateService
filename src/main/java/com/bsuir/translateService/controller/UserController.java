package com.bsuir.translateService.controller;

import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.UserService;
import com.bsuir.translateService.utils.DiffAlgorithmString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Олег Пятко on 07.05.2017.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserEntity>> findAllUsers(){
        Iterable<UserEntity> users = userService.findAll();
        DiffAlgorithmString lcsString = new DiffAlgorithmString("big brown dog", "small brown cat");
        String diff = lcsString.getHtmlDiff();
        return new ResponseEntity<Iterable<UserEntity>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findUserById(@PathVariable(value = "id")int id){
        UserEntity users = userService.findById(id);
        return new ResponseEntity<UserEntity>(users, HttpStatus.OK);
    }
/*
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
*/
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
    }
}
