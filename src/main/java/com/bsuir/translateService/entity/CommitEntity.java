package com.bsuir.translateService.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Олег Пятко on 21.05.2017.
 */
@Entity
@Table(name = "commit", schema = "git_translate", catalog = "")
public class CommitEntity {
    private int idCommit;
    private String translatedText;
    private Timestamp createTime;
    private int idBranch;
    private String commitMessage;
    private Integer nextCommitId;
    private Integer previousCommitId;
    private String hash;

    @Id
    @Column(name = "idCommit", nullable = false)
    public int getIdCommit() {
        return idCommit;
    }

    public void setIdCommit(int idCommit) {
        this.idCommit = idCommit;
    }

    @Basic
    @Column(name = "translatedText", nullable = true, length = -1)
    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "idBranch", nullable = false)
    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
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
        if (commitMessage != null ? !commitMessage.equals(that.commitMessage) : that.commitMessage != null)
            return false;
        if (nextCommitId != null ? !nextCommitId.equals(that.nextCommitId) : that.nextCommitId != null) return false;
        if (previousCommitId != null ? !previousCommitId.equals(that.previousCommitId) : that.previousCommitId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCommit;
        result = 31 * result + (translatedText != null ? translatedText.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + idBranch;
        result = 31 * result + (commitMessage != null ? commitMessage.hashCode() : 0);
        result = 31 * result + (nextCommitId != null ? nextCommitId.hashCode() : 0);
        result = 31 * result + (previousCommitId != null ? previousCommitId.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "hash", nullable = false, length = 8)
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
