package com.bsuir.translateService.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 21.05.2017.
 */
@Entity
@Table(name = "branch", schema = "git_translate", catalog = "")
public class BranchEntity {
    private int idBranch;
    private String name;
    private String plainText;
    private int idRepository;
    private int idUser;
    private byte isMainUser;

    @Id
    @Column(name = "idBranch", nullable = false)
    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "plainText", nullable = false, length = -1)
    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    @Basic
    @Column(name = "idRepository", nullable = false)
    public int getIdRepository() {
        return idRepository;
    }

    public void setIdRepository(int idRepository) {
        this.idRepository = idRepository;
    }

    @Basic
    @Column(name = "idUser", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "isMainUser", nullable = false)
    public byte getIsMainUser() {
        return isMainUser;
    }

    public void setIsMainUser(byte isMainUser) {
        this.isMainUser = isMainUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchEntity that = (BranchEntity) o;

        if (idBranch != that.idBranch) return false;
        if (idRepository != that.idRepository) return false;
        if (idUser != that.idUser) return false;
        if (isMainUser != that.isMainUser) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (plainText != null ? !plainText.equals(that.plainText) : that.plainText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBranch;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (plainText != null ? plainText.hashCode() : 0);
        result = 31 * result + idRepository;
        result = 31 * result + idUser;
        result = 31 * result + (int) isMainUser;
        return result;
    }
}
