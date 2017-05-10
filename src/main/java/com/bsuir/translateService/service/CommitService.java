package com.bsuir.translateService.service;

import com.bsuir.translateService.dao.CommitRepository;
import com.bsuir.translateService.entity.CommitEntity;
import com.bsuir.translateService.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Олег Пятко on 10.05.2017.
 */
@Service
public class CommitService {

    public Iterable<CommitEntity> findAll(){
        return commitRepository.findAll();
    }

    public CommitEntity findById(int id){
        CommitEntity commitEntity = commitRepository.findById(id);

        if (commitEntity == null){
            throw new ServiceException("commit with id " + id + "not found");
        }

        return commitEntity;
    }

    public Iterable<CommitEntity> findByBranchId(int id){
        return commitRepository.findByBranchId(id);
    }

    public void createCommit(CommitEntity commitEntity){
        commitRepository.createCommit(commitEntity);
    }

    public void deleteCommit(CommitEntity commitEntity){
        commitRepository.deleteCommit(commitEntity);
    }

    private CommitRepository commitRepository;

    @Autowired
    public void setCommitRepository(CommitRepository commitRepository) {
        this.commitRepository = commitRepository;
    }
}
