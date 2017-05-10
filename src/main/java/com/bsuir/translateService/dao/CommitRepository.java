package com.bsuir.translateService.dao;

import com.bsuir.translateService.entity.CommitEntity;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@org.springframework.stereotype.Repository
@Transactional
public interface CommitRepository {
    Iterable<CommitEntity> findAll();
    CommitEntity findById(int id);
    Iterable<CommitEntity> findByBranchId(int id);
    CommitEntity findLastCommitInBranch(int branchId);
    public CommitEntity findFirstCommitInBranch(int branchId);
    void createCommit(CommitEntity commitEntity);
    void updateCommit(CommitEntity commitEntity);
    void deleteCommit(CommitEntity commitEntity);
}