package com.bsuir.translateService.dao;

import com.bsuir.translateService.entity.RepositoryEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@org.springframework.stereotype.Repository
@Transactional
public interface Repository {
    Iterable<RepositoryEntity> findAll();
    RepositoryEntity findById(int id);
    RepositoryEntity findByName(String name);
    void createRepository(RepositoryEntity repositoryEntity);
    void updateRepository(RepositoryEntity repositoryEntity);
    void deleteRepository(RepositoryEntity repositoryEntity);
}
