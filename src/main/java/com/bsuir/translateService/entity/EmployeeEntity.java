package com.bsuir.translateService.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 08.05.2017.
 */
@Entity
@Table(name = "employee", schema = "git_translate", catalog = "")
public class EmployeeEntity {
    private int idEmployee;
    private byte isMainUser;
    private UserEntity userByIdUser;
    private RepositoryEntity repositoryByIdRepository;

    @Id
    @Column(name = "idEmployee", nullable = false)
    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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
        if (isMainUser != that.isMainUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmployee;
        result = 31 * result + (int) isMainUser;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    public UserEntity getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(UserEntity userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "idRepository", referencedColumnName = "idRepository", nullable = false)
    public RepositoryEntity getRepositoryByIdRepository() {
        return repositoryByIdRepository;
    }

    public void setRepositoryByIdRepository(RepositoryEntity repositoryByIdRepository) {
        this.repositoryByIdRepository = repositoryByIdRepository;
    }
}
