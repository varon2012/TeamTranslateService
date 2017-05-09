package com.bsuir.translateService.dao.impl;

import com.bsuir.translateService.dao.Repository;
import com.bsuir.translateService.entity.RepositoryEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@org.springframework.stereotype.Repository
@Transactional
public class RepositoryImpl extends BaseRepository implements Repository {
    @Override
    public Iterable<RepositoryEntity> findAll() {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from RepositoryEntity ");
        Iterable<RepositoryEntity> repositories = query.list();
        return repositories;
    }

    @Override
    public RepositoryEntity findById(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from RepositoryEntity u where u.idRepository = :id");
        query.setParameter("id", id);
        List<RepositoryEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public RepositoryEntity findByName(String name) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from RepositoryEntity u where u.name = :name");
        query.setParameter("name", name);
        List<RepositoryEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void createRepository(RepositoryEntity repositoryEntity) {
        Session session = GetCurrentSession();

        session.save(repositoryEntity);
    }

    @Override
    public void updateRepository(RepositoryEntity repositoryEntity) {
        Session session = GetCurrentSession();

        session.update(repositoryEntity);
    }

    @Override
    public void deleteRepository(RepositoryEntity repositoryEntity) {
        Session session = GetCurrentSession();

        session.delete(repositoryEntity);
    }
}
