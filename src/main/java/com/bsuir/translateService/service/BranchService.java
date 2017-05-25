package com.bsuir.translateService.service;

import com.bsuir.translateService.dao.BranchRepository;
import com.bsuir.translateService.dto.BranchDto;
import com.bsuir.translateService.entity.BranchEntity;
import com.bsuir.translateService.entity.CommitEntity;
import com.bsuir.translateService.service.exception.ServiceException;
import com.bsuir.translateService.utils.HelpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Iterable<BranchEntity> findByRepositoryId(int id){
        return branchRepository.findByIdRepository(id);
    }

    public Iterable<BranchEntity> findByUserId(int id){
        return branchRepository.findByIdUser(id);
    }

    public Iterable<BranchEntity> findByUserIdAndMainUser(int id){
        return branchRepository.findByIdAndMainUser(id);
    }

    public Iterable<BranchDto> getAllUsersTasks(int userId){
        Iterable<BranchEntity> branches = findByUserId(userId);
        List<BranchDto> result = new ArrayList<BranchDto>();
        for (BranchEntity branchEntity: branches) {
            BranchDto dto = new BranchDto();
            dto.setEntity(branchEntity);

            List<CommitEntity> commits = (List<CommitEntity>) commitService.findByBranchId(branchEntity.getIdBranch());
            dto.setCommitNumber(commits.size());

            CommitEntity commitEntity = commitService.findLastCommitInBranch(branchEntity.getIdBranch());
            if (commitEntity != null){
                dto.setLastCommitMessage(commitEntity.getCommitMessage());
            }


            String repoName = repositoryService.findById(branchEntity.getIdRepository()).getName();
            dto.setRepositoryName(repoName);

            result.add(dto);
        }
        return result;
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

    private CommitService commitService;
    private RepositoryService repositoryService;
    private BranchRepository branchRepository;


    @Autowired
    public void setBranchRepository(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Autowired
    public void setCommitService(CommitService commitService) {
        this.commitService = commitService;
    }

    @Autowired
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }
}
