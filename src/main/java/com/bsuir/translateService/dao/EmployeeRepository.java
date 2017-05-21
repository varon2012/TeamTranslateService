package com.bsuir.translateService.dao;

import com.bsuir.translateService.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by Олег Пятко on 09.05.2017.
 */
//@Repository
//@Transactional
public interface EmployeeRepository {
    Iterable<EmployeeEntity> findAll();
    Iterable<EmployeeEntity> findByUserId(int id);
    EmployeeEntity findById(int id);
    Iterable<EmployeeEntity> findByRepositoryid(int id);
    void createEmployee(EmployeeEntity employeeEntity);
    void updateEmployee(EmployeeEntity employeeEntity);
    void deleteEmployee(EmployeeEntity employeeEntity);
}
