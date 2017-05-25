package com.bsuir.translateService.dto;

import com.bsuir.translateService.entity.RepositoryEntity;

/**
 * Created by Олег Пятко on 22.05.2017.
 */
public class CreateRepositoryDto {
    private RepositoryEntity repository;
    private String plainText;
    public RepositoryEntity getRepository() {
        return repository;
    }

    public void setRepository(RepositoryEntity repository) {
        this.repository = repository;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }
}
