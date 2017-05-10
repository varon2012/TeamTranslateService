package com.bsuir.translateService.service;

import com.bsuir.translateService.dao.EmployeeRepository;
import com.bsuir.translateService.entity.EmployeeEntity;
import com.bsuir.translateService.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@Service
public class EmployeeService {
    public Iterable<EmployeeEntity> findAll(){
        return employeeRepository.findAll();
    }

    public EmployeeEntity findById(int id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id);

        if (employeeEntity == null){
            throw new ServiceException("employee with id" + id + "not found");
        }

        return employeeEntity;
    }

    public Iterable<EmployeeEntity> findByRepositoryId(int id){
        return employeeRepository.findByRepositoryid(id);
    }

    public Iterable<EmployeeEntity> findByUserId(int id){
        return employeeRepository.findByUserId(id);
    }

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity){
        employeeRepository.createEmployee(employeeEntity);
        Iterable<EmployeeEntity> repositoriesList = employeeRepository.findByRepositoryid(employeeEntity.getIdEmployee());
        Iterable<EmployeeEntity> usersList = employeeRepository.findByUserId(employeeEntity.getIdUser());

        for (EmployeeEntity employee : repositoriesList) {
            for (EmployeeEntity employeeUser : usersList){
                if (employee.getIdRepository() == employeeEntity.getIdRepository()
                        && employeeUser.getIdUser() == employeeEntity.getIdUser()){
                    return employee;
                }
            }
        }

        return employeeEntity;
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity){
        employeeRepository.updateEmployee(employeeEntity);
        return employeeEntity;
    }

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
