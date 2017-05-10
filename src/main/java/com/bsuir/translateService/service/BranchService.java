package com.bsuir.translateService.service;

import com.bsuir.translateService.dao.BranchRepository;
import com.bsuir.translateService.entity.BranchEntity;
import com.bsuir.translateService.service.exception.ServiceException;
import com.bsuir.translateService.utils.HelpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Олег Пятко on 10.05.2017.
 */
@Service
public class BranchService {

    public Iterable<BranchEntity> findAll(){
        return branchRepository.findAll();
    }

    public BranchEntity findById(int id){
        BranchEntity branchEntity = branchRepository.findById(id);

        if (branchEntity == null){
            throw new ServiceException("branch with id " + id + " not found");
        }

        return branchEntity;
    }

    public Iterable<BranchEntity> findByEmployeeId(int id){
        return branchRepository.findByEmployeeId(id);
    }

    public BranchEntity findByName(String name){
        return branchRepository.findByName(name);
    }

    public void createBranch(BranchEntity branchEntity){
        validateBranch(branchEntity);
        branchRepository.createBranch(branchEntity);
    }

    public void updateBranch(BranchEntity branchEntity){
        validateBranch(branchEntity);
        branchRepository.updateBranch(branchEntity);
    }

    public void deleteBranch(BranchEntity branchEntity){
        branchRepository.deleteBranch(branchEntity);
    }

    private void validateBranch(BranchEntity branchEntity){
        if (HelpUtils.isNullOrEmpty(branchEntity.getName())){
            throw new ServiceException("name cannot be empty");
        }
    }

    private BranchRepository branchRepository;

    @Autowired
    public void setBranchRepository(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }
}
