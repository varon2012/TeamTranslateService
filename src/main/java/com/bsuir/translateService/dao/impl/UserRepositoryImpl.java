package com.bsuir.translateService.dao.impl;

import com.bsuir.translateService.dao.UserRepository;
import com.bsuir.translateService.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import java.util.List;

/**
 * Created by Олег Пятко on 07.05.2017.
 */
@Repository
@Transactional
public class UserRepositoryImpl extends BaseRepository implements UserRepository {

    @Override
    public Iterable<UserEntity> findAll() {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from UserEntity ");
        Iterable<UserEntity> users = query.list();
        return users;
    }

    @Override
    public UserEntity findByLogin(String login) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from UserEntity u where u.login = :login");
        query.setParameter("login", login);
        List<UserEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public UserEntity findById(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from UserEntity u where u.idUser = :id");
        query.setParameter("id", id);
        List<UserEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public UserEntity findByEmail(String email) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from UserEntity u where u.email = :email");
        query.setParameter("email", email);
        List<UserEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void createUser(UserEntity userEntity) {
        Session session = GetCurrentSession();

        session.save(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        Session session = GetCurrentSession();

        session.update(userEntity);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        Session session = GetCurrentSession();

        session.delete(userEntity);
    }
}