package com.bsuir.translateService.dto;

import com.bsuir.translateService.entity.CommitEntity;

import java.util.List;

/**
 * Created by Олег Пятко on 21.05.2017.
 */
public class CommitDto {
    private CommitEntity entity;

    public CommitEntity getEntity() {
        return entity;
    }

    public void setEntity(CommitEntity entity) {
        this.entity = entity;
    }
}
