package com.bsuir.translateService.dao.impl;

import com.bsuir.translateService.dao.CommitRepository;
import com.bsuir.translateService.entity.CommitEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@Repository
@Transactional
public class CommitRepositoryImpl extends BaseRepository implements CommitRepository {
    @Override
    public Iterable<CommitEntity> findAll() {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from CommitEntity");
        Iterable<CommitEntity> repositories = query.list();
        return repositories;
    }

    @Override
    public CommitEntity findById(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from CommitEntity u where u.idCommit = :id");
        query.setParameter("id", id);
        List<CommitEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Iterable<CommitEntity> findByBranchId(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from CommitEntity u where u.idBranch = :id");
        query.setParameter("id", id);
        List<CommitEntity> list = query.list();
        return list;
    }

    @Override
    public void createBranch(CommitEntity commitEntity) {
        Session session = GetCurrentSession();

        session.save(commitEntity);
    }

    @Override
    public void updateBranch(CommitEntity commitEntity) {
        Session session = GetCurrentSession();

        session.update(commitEntity);
    }

    @Override
    public void deleteBranch(CommitEntity commitEntity) {
        Session session = GetCurrentSession();

        session.delete(commitEntity);
    }
}
