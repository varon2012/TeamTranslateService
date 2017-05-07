package com.bsuir.translateService.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Олег Пятко on 07.05.2017.
 */
@Entity
@Table(name = "repository", schema = "git_translate")
public class RepositoryEntity {
    private int idRepository;
    private String name;
    private Timestamp createTime;
    private Collection<EmployeeEntity> employeesByIdRepository;
    private Collection<InvitationEntity> invitationsByIdRepository;

    @Id
    @Column(name = "idRepository")
    public int getIdRepository() {
        return idRepository;
    }

    public void setIdRepository(int idRepository) {
        this.idRepository = idRepository;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "createTime")
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

        RepositoryEntity that = (RepositoryEntity) o;

        if (idRepository != that.idRepository) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRepository;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "repositoryByIdRepository")
    public Collection<EmployeeEntity> getEmployeesByIdRepository() {
        return employeesByIdRepository;
    }

    public void setEmployeesByIdRepository(Collection<EmployeeEntity> employeesByIdRepository) {
        this.employeesByIdRepository = employeesByIdRepository;
    }

    @OneToMany(mappedBy = "repositoryByIdRepository")
    public Collection<InvitationEntity> getInvitationsByIdRepository() {
        return invitationsByIdRepository;
    }

    public void setInvitationsByIdRepository(Collection<InvitationEntity> invitationsByIdRepository) {
        this.invitationsByIdRepository = invitationsByIdRepository;
    }
}
