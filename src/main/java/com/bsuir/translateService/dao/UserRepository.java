package com.bsuir.translateService.dao;

import com.bsuir.translateService.entity.UserEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 07.05.2017.
 */
@Repository
@Transactional
public interface UserRepository {
    Iterable<UserEntity> findAll();
    UserEntity findByLogin(String login);
    UserEntity findById(int id);
    UserEntity findByEmail(String email);
    Integer createUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    void deleteUser(UserEntity userEntity);
}
