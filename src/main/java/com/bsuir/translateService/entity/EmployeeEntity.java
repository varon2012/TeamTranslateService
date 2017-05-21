package com.bsuir.translateService.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
//@Entity
//@Table(name = "employee", schema = "git_translate")
public class EmployeeEntity {
    private int idEmployee;
    private int idUser;
    private int idRepository;
    private byte isMainUser;

    @Id
    @Column(name = "idEmployee", nullable = false)
    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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
    @Column(name = "idRepository", nullable = false)
    public int getIdRepository() {
        return idRepository;
    }

    public void setIdRepository(int idRepository) {
        this.idRepository = idRepository;
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

        EmployeeEntity that = (EmployeeEntity) o;

        if (idEmployee != that.idEmployee) return false;
        if (idUser != that.idUser) return false;
        if (idRepository != that.idRepository) return false;
        if (isMainUser != that.isMainUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmployee;
        result = 31 * result + idUser;
        result = 31 * result + idRepository;
        result = 31 * result + (int) isMainUser;
        return result;
    }
}
