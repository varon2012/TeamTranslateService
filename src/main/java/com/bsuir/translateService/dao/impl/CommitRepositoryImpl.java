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
    public CommitEntity findLastCommitInBranch(int branchId) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from CommitEntity c where c.idBranch = :branchId and c.nextCommitId = null");
        query.setParameter("branchId", branchId);
        List<CommitEntity> list = query.list();

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    public CommitEntity findFirstCommitInBranch(int branchId){
        Session session = GetCurrentSession();
        Query query = session.createQuery("from CommitEntity c where c.idBranch = :branchId and c.previousCommitId = null");
        query.setParameter("branchId", branchId);
        List<CommitEntity> list = query.list();

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public CommitEntity findByHash(String hash) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from CommitEntity c where c.hash = :hash");
        query.setParameter("hash", hash);
        List<CommitEntity> list = query.list();

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public void createCommit(CommitEntity commitEntity) {
        Session session = GetCurrentSession();
        commitEntity.setHash(Long.toString(System.nanoTime()).substring(8));
        session.save(commitEntity);
    }

    @Override
    public void updateCommit(CommitEntity commitEntity) {
        Session session = GetCurrentSession();

        session.update(commitEntity);
    }

    @Override
    public void deleteCommit(CommitEntity commitEntity) {
        Session session = GetCurrentSession();

        session.delete(commitEntity);
    }
}
