package com.bsuir.translateService.dao.impl;

import com.bsuir.translateService.dao.BranchRepository;
import com.bsuir.translateService.dto.BranchDto;
import com.bsuir.translateService.entity.BranchEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@Repository
@Transactional
public class BranchRepositoryImpl extends BaseRepository implements BranchRepository {
    @Override
    public Iterable<BranchEntity> findAll() {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from BranchEntity ");
        Iterable<BranchEntity> branches = query.list();
        return branches;
    }

    @Override
    public BranchEntity findByName(String name) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from BranchEntity u where u.name = :name");
        query.setParameter("name", name);
        List<BranchEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public BranchEntity findById(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from BranchEntity u where u.idBranch = :id");
        query.setParameter("id", id);
        List<BranchEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Iterable<BranchEntity> findByIdRepository(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from BranchEntity u where u.idRepository = :id");
        query.setParameter("id", id);
        List<BranchEntity> list = query.list();
        return list;
    }

    @Override
    public Iterable<BranchEntity> findByIdUser(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from BranchEntity u where u.idUser = :id");
        query.setParameter("id", id);
        List<BranchEntity> list = query.list();
        return list;
    }

    @Override
    public Iterable<BranchEntity> findByIdAndMainUser(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from BranchEntity u where u.idUser = :id and  u.isMainUser = 1");
        query.setParameter("id", id);
        List<BranchEntity> list = query.list();
        return list;
    }

    @Override
    public void createBranch(BranchEntity branchEntity) {
        Session session = GetCurrentSession();
        session.save(branchEntity);
    }

    @Override
    public void updateBranch(BranchEntity branchEntity) {
        Session session = GetCurrentSession();

        session.update(branchEntity);
    }

    @Override
    public void deleteBranch(BranchEntity branchEntity) {
        Session session = GetCurrentSession();

        session.delete(branchEntity);
    }
}
