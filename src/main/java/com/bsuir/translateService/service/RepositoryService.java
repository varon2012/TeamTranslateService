package com.bsuir.translateService.service;

import com.bsuir.translateService.dao.Repository;
import com.bsuir.translateService.entity.RepositoryEntity;
import com.bsuir.translateService.service.exception.ServiceException;
import com.bsuir.translateService.utils.HelpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@Service
public class RepositoryService {
    public Iterable<RepositoryEntity> findAll(){
        return repositoryService.findAll();
    }

    public RepositoryEntity findById(int id){
        RepositoryEntity repositoryEntity = repositoryService.findById(id);

        if (repositoryEntity == null) {
            throw new ServiceException("repository with id" + id + " not found");
        }
        return repositoryEntity;
    }

    public RepositoryEntity findByName(String name){
        RepositoryEntity repositoryEntity = repositoryService.findByName(name);

        if (repositoryEntity == null){
            throw new ServiceException("repository with name" + name + "not found");
        }

        return repositoryEntity;
    }

    public RepositoryEntity createRepository(RepositoryEntity repositoryEntity){
        validateRepository(repositoryEntity);
        repositoryService.createRepository(repositoryEntity);
        return repositoryService.findByName(repositoryEntity.getName());
    }

    public RepositoryEntity updateRepository(RepositoryEntity repositoryEntity){
        validateRepositoryName(repositoryEntity);
        repositoryService.updateRepository(repositoryEntity);
        return repositoryService.findByName(repositoryEntity.getName());
    }

    public void deleteRepository(RepositoryEntity repositoryEntity){
        repositoryService.deleteRepository(repositoryEntity);
    }

    private void validateRepositoryName(RepositoryEntity repositoryEntity){
        if (HelpUtils.isNullOrEmpty(repositoryEntity.getName())){
            throw new ServiceException("repository name can't be empty");
        }
    }

    private void validateRepository(RepositoryEntity repositoryEntity){
        validateRepositoryName(repositoryEntity);

        if (repositoryService.findByName(repositoryEntity.getName()) != null){
            throw new ServiceException("repository with name " + repositoryEntity.getName() + "exists");
        }
    }

    private Repository repositoryService;

    @Autowired
    public void setRepositoryService(Repository repository) {
        this.repositoryService = repository;
    }
}
