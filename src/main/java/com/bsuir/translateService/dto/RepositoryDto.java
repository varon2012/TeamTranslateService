package com.bsuir.translateService.dto;

import com.bsuir.translateService.entity.RepositoryEntity;

/**
 * Created by Олег Пятко on 22.05.2017.
 */
public class RepositoryDto {
    private RepositoryEntity entity;
    private int tasks;

    public RepositoryEntity getEntity() {
        return entity;
    }

    public void setEntity(RepositoryEntity entity) {
        this.entity = entity;
    }

    public int getTasks() {
        return tasks;
    }

    public void setTasks(int tasks) {
        this.tasks = tasks;
    }
}
