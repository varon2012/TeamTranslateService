package com.bsuir.translateService.service.Impl;

import com.bsuir.translateService.dao.UserRepository;
import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.UserService;
import com.bsuir.translateService.service.exception.ServiceException;
import com.bsuir.translateService.utils.HelpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by Олег Пятко on 08.05.2017.
 */
/*
@Service
public class UserServiceImpl implements UserService{

    @Transactional
    public Iterable<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public UserEntity findByLogin(String login) throws IllegalArgumentException, ServiceException {
        Assert.notNull(login, "login can't be null");
        if(login.isEmpty()){
            throw new IllegalArgumentException("login can't be empty");
        }

        UserEntity user = userRepository.findByLogin(login);

        if (user == null){
            throw new ServiceException("User with login " + login + " doesn't exists");
        }

        return user;
    }

    @Transactional
    public UserEntity findById(int id){
        UserEntity user = userRepository.findById(id);

        if (user == null){
            throw new ServiceException("User with id " + id + " doesn't exists");
        }

        return user;
    }

    @Override
    public UserEntity findByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);

        if (user == null){
            throw new ServiceException("User with email " + email + " doesnt exists");
        }

        return user;
    }

    @Transactional
    public UserEntity createUser(UserEntity userEntity){
        validateUser(userEntity);
        Integer id = userRepository.createUser(userEntity);
        UserEntity user = userRepository.findById(id);
        return user;
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        validateUser(userEntity);
        userRepository.updateUser(userEntity);
    }

    private void validateUser(UserEntity userEntity){
        if (userEntity == null){
            throw new ServiceException("user can't be null");
        }

        if (HelpUtils.isNullOrEmpty(userEntity.getEmail())){
            throw new ServiceException("email can't be null");
        }

        if (userRepository.findByEmail(userEntity.getEmail()) != null){
            throw new ServiceException("user with such email already exists");
        }

        if (HelpUtils.isNullOrEmpty(userEntity.getLogin())){
            throw new ServiceException("login can't be null");
        }

        if (userRepository.findByLogin(userEntity.getLogin()) != null){
            throw new ServiceException("user with such login already exists");
        }

        if (HelpUtils.isNullOrEmpty(userEntity.getPasswordHash())){
            throw new ServiceException("wrong password");
        }
    }

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
            this.userRepository = userRepository;
        }
}
*/