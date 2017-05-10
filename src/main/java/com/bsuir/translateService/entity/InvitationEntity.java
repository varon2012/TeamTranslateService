package com.bsuir.translateService.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@Entity
@Table(name = "invitation", schema = "git_translate", catalog = "")
public class InvitationEntity {
    private int idInvitation;
    private int idInvitedUser;
    private int idInviter;
    private int idRepository;
    private String invitationText;

    @Id
    @Column(name = "idInvitation", nullable = false)
    public int getIdInvitation() {
        return idInvitation;
    }

    public void setIdInvitation(int idInvitation) {
        this.idInvitation = idInvitation;
    }

    @Basic
    @Column(name = "idInvitedUser", nullable = false)
    public int getIdInvitedUser() {
        return idInvitedUser;
    }

    public void setIdInvitedUser(int idInvitedUser) {
        this.idInvitedUser = idInvitedUser;
    }

    @Basic
    @Column(name = "idInviter", nullable = false)
    public int getIdInviter() {
        return idInviter;
    }

    public void setIdInviter(int idInviter) {
        this.idInviter = idInviter;
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
    @Column(name = "invitationText", nullable = true, length = 200)
    public String getInvitationText() {
        return invitationText;
    }

    public void setInvitationText(String invitationText) {
        this.invitationText = invitationText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvitationEntity that = (InvitationEntity) o;

        if (idInvitation != that.idInvitation) return false;
        if (idInvitedUser != that.idInvitedUser) return false;
        if (idInviter != that.idInviter) return false;
        if (idRepository != that.idRepository) return false;
        if (invitationText != null ? !invitationText.equals(that.invitationText) : that.invitationText != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInvitation;
        result = 31 * result + idInvitedUser;
        result = 31 * result + idInviter;
        result = 31 * result + idRepository;
        result = 31 * result + (invitationText != null ? invitationText.hashCode() : 0);
        return result;
    }
}
