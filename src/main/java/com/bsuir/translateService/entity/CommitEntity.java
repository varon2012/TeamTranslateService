package com.bsuir.translateService.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@Entity
@Table(name = "commit", schema = "git_translate", catalog = "")
public class CommitEntity {
    private int idCommit;
    private String translatedText;
    private String commitText;
    private Timestamp createTime;
    private int idBranch;
    private String commitMessage;
    private Integer nextCommitId;
    private Integer previousCommitId;

    @Id
    @Column(name = "idCommit", nullable = false)
    public int getIdCommit() {
        return idCommit;
    }

    public void setIdCommit(int idCommit) {
        this.idCommit = idCommit;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "commitMessage", nullable = false, length = 200)
    public String getCommitMessage() {
        return commitMessage;
    }

    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }

    @Basic
    @Column(name = "idBranch", nullable = false)
    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommitEntity that = (CommitEntity) o;

        if (idCommit != that.idCommit) return false;
        if (idBranch != that.idBranch) return false;
        if (translatedText != null ? !translatedText.equals(that.translatedText) : that.translatedText != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCommit;
        result = 31 * result + (translatedText != null ? translatedText.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + idBranch;
        return result;
    }

    @Basic
    @Column(name = "nextCommitId", nullable = true)
    public Integer getNextCommitId() {
        return nextCommitId;
    }

    public void setNextCommitId(Integer nextCommitId) {
        this.nextCommitId = nextCommitId;
    }

    @Basic
    @Column(name = "previousCommitId", nullable = true)
    public Integer getPreviousCommitId() {
        return previousCommitId;
    }

    public void setPreviousCommitId(Integer previousCommitId) {
        this.previousCommitId = previousCommitId;
    }
}
