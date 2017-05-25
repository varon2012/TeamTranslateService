package com.bsuir.translateService.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 21.05.2017.
 */
@Entity
@Table(name = "invitation", schema = "git_translate", catalog = "")
public class InvitationEntity {
    private int idInvitation;
    private int idInvitedUser;
    private int idInviter;
    private int idRepository;
    private String invitationText;
    private byte isAccepted;

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

        InvitationEntity entity = (InvitationEntity) o;

        if (idInvitation != entity.idInvitation) return false;
        if (idInvitedUser != entity.idInvitedUser) return false;
        if (idInviter != entity.idInviter) return false;
        if (idRepository != entity.idRepository) return false;
        if (invitationText != null ? !invitationText.equals(entity.invitationText) : entity.invitationText != null)
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

    @Basic
    @Column(name = "isAccepted", nullable = false)
    public byte getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(byte isAccepted) {
        this.isAccepted = isAccepted;
    }
}
