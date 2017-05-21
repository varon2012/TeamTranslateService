package com.bsuir.translateService.dao.impl;

import com.bsuir.translateService.dao.EmployeeRepository;
import com.bsuir.translateService.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
//@Repository
//@Transactional
public class EmployeeRepositoryImpl extends BaseRepository implements EmployeeRepository {
    @Override
    public Iterable<EmployeeEntity> findAll() {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from EmployeeEntity");
        Iterable<EmployeeEntity> repositories = query.list();
        return repositories;
    }

    @Override
    public Iterable<EmployeeEntity> findByUserId(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from EmployeeEntity u where u.idUser = :id");
        query.setParameter("id", id);
        List<EmployeeEntity> list = query.list();
        return list;
    }

    @Override
    public EmployeeEntity findById(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from EmployeeEntity u where u.idEmployee = :id");
        query.setParameter("id", id);
        List<EmployeeEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Iterable<EmployeeEntity> findByRepositoryid(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from EmployeeEntity u where u.idRepository = :id");
        query.setParameter("id", id);
        List<EmployeeEntity> list = query.list();
        return list;
    }

    @Override
    public void createEmployee(EmployeeEntity employeeEntity) {
        Session session = GetCurrentSession();

        session.save(employeeEntity);
    }

    @Override
    public void updateEmployee(EmployeeEntity employeeEntity) {
        Session session = GetCurrentSession();

        session.update(employeeEntity);
    }

    @Override
    public void deleteEmployee(EmployeeEntity employeeEntity) {
        Session session = GetCurrentSession();

        session.delete(employeeEntity);
    }
}
