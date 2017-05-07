package com.bsuir.translateService.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Олег Пятко on 07.05.2017.
 */
@Entity
@Table(name = "user", schema = "git_translate")
public class UserEntity {
    private int idUser;
    private String login;
    private String email;
    private String passwordHash;
    private Timestamp createTime;
    private String about;
    private String role;
    private Collection<EmployeeEntity> employeesByIdUser;
    private Collection<InvitationEntity> invitationsByIdUser;
    private Collection<InvitationEntity> invitationsByIdUser_0;

    @Id
    @Column(name = "idUser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "passwordHash")
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "about")
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (idUser != that.idUser) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (passwordHash != null ? !passwordHash.equals(that.passwordHash) : that.passwordHash != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (about != null ? !about.equals(that.about) : that.about != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByIdUser")
    public Collection<EmployeeEntity> getEmployeesByIdUser() {
        return employeesByIdUser;
    }

    public void setEmployeesByIdUser(Collection<EmployeeEntity> employeesByIdUser) {
        this.employeesByIdUser = employeesByIdUser;
    }

    @OneToMany(mappedBy = "userByIdInvitedUser")
    public Collection<InvitationEntity> getInvitationsByIdUser() {
        return invitationsByIdUser;
    }

    public void setInvitationsByIdUser(Collection<InvitationEntity> invitationsByIdUser) {
        this.invitationsByIdUser = invitationsByIdUser;
    }

    @OneToMany(mappedBy = "userByIdInviter")
    public Collection<InvitationEntity> getInvitationsByIdUser_0() {
        return invitationsByIdUser_0;
    }

    public void setInvitationsByIdUser_0(Collection<InvitationEntity> invitationsByIdUser_0) {
        this.invitationsByIdUser_0 = invitationsByIdUser_0;
    }
}
