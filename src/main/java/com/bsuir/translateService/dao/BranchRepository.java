package com.bsuir.translateService.dao;

import com.bsuir.translateService.entity.BranchEntity;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@org.springframework.stereotype.Repository
@Transactional
public interface BranchRepository {
    Iterable<BranchEntity> findAll();
    BranchEntity findByName(String name);
    BranchEntity findById(int id);
    Iterable<BranchEntity> findByEmployeeId(int id);
    void createBranch(BranchEntity BranchEntity);
    void updateBranch(BranchEntity BranchEntity);
    void deleteBranch(BranchEntity BranchEntity);
}
