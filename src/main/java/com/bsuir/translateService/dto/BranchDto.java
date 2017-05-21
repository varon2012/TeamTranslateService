package com.bsuir.translateService.dto;

import com.bsuir.translateService.entity.BranchEntity;

/**
 * Created by Олег Пятко on 17.05.2017.
 */
public class BranchDto {
    private BranchEntity entity;
    private String repositoryName;
    private String lastCommitMessage;
    private int commitNumber;

    public BranchEntity getEntity() {
        return entity;
    }

    public void setEntity(BranchEntity entity) {
        this.entity = entity;
    }

    public int getCommitNumber() {
        return commitNumber;
    }

    public void setCommitNumber(int commitNumber) {
        this.commitNumber = commitNumber;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getLastCommitMessage() {
        return lastCommitMessage;
    }

    public void setLastCommitMessage(String lastCommitMessage) {
        this.lastCommitMessage = lastCommitMessage;
    }
}
