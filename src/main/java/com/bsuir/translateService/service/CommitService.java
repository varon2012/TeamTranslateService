package com.bsuir.translateService.service;

import com.bsuir.translateService.dao.CommitRepository;
import com.bsuir.translateService.dto.CommitDto;
import com.bsuir.translateService.entity.CommitEntity;
import com.bsuir.translateService.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public CommitEntity findLastCommitInBranch(int branchId){
        return commitRepository.findLastCommitInBranch(branchId);
    }

    public Iterable<CommitDto> getCommitList(int branchId){
        List<CommitEntity> commits = (List<CommitEntity>) findByBranchId(branchId);
        Collections.sort(commits, new Comparator<CommitEntity>() {
            @Override
            public int compare(CommitEntity o1, CommitEntity o2) {
                if (o1.getIdCommit() < o2.getIdCommit()){
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });
        List<CommitDto> result = new ArrayList<>();
        for (CommitEntity commit : commits) {
            CommitDto commitDto = new CommitDto();
            commitDto.setEntity(commit);
            result.add(commitDto);
        }
        Collections.reverse(result);

        return result;
    }

    public CommitEntity findByHash(String hash){
        return commitRepository.findByHash(hash);
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

    public void updateCommit(CommitEntity commitEntity){
        commitRepository.updateCommit(commitEntity);
    }

    private CommitRepository commitRepository;

    @Autowired
    public void setCommitRepository(CommitRepository commitRepository) {
        this.commitRepository = commitRepository;
    }
}
