package com.bsuir.translateService.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Олег Пятко on 08.05.2017.
 */
@Entity
@Table(name = "commit", schema = "git_translate", catalog = "")
public class CommitEntity {
    private int idCommit;
    private String plainText;
    private String translatedText;
    private Timestamp createTime;

    @Id
    @Column(name = "idCommit", nullable = false)
    public int getIdCommit() {
        return idCommit;
    }

    public void setIdCommit(int idCommit) {
        this.idCommit = idCommit;
    }

    @Basic
    @Column(name = "plainText", nullable = true, length = -1)
    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
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
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommitEntity that = (CommitEntity) o;

        if (idCommit != that.idCommit) return false;
        if (plainText != null ? !plainText.equals(that.plainText) : that.plainText != null) return false;
        if (translatedText != null ? !translatedText.equals(that.translatedText) : that.translatedText != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCommit;
        result = 31 * result + (plainText != null ? plainText.hashCode() : 0);
        result = 31 * result + (translatedText != null ? translatedText.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
