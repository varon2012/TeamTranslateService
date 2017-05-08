package com.bsuir.translateService.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 08.05.2017.
 */
@Entity
@Table(name = "invitation", schema = "git_translate", catalog = "")
public class InvitationEntity {
    private int idInvitation;
    private String invitationText;
    private String invitationcol;
    private UserEntity userByIdInvitedUser;
    private UserEntity userByIdInviter;
    private RepositoryEntity repositoryByIdRepository;

    @Id
    @Column(name = "idInvitation", nullable = false)
    public int getIdInvitation() {
        return idInvitation;
    }

    public void setIdInvitation(int idInvitation) {
        this.idInvitation = idInvitation;
    }

    @Basic
    @Column(name = "invitationText", nullable = true, length = 200)
    public String getInvitationText() {
        return invitationText;
    }

    public void setInvitationText(String invitationText) {
        this.invitationText = invitationText;
    }

    @Basic
    @Column(name = "Invitationcol", nullable = true, length = 45)
    public String getInvitationcol() {
        return invitationcol;
    }

    public void setInvitationcol(String invitationcol) {
        this.invitationcol = invitationcol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvitationEntity that = (InvitationEntity) o;

        if (idInvitation != that.idInvitation) return false;
        if (invitationText != null ? !invitationText.equals(that.invitationText) : that.invitationText != null)
            return false;
        if (invitationcol != null ? !invitationcol.equals(that.invitationcol) : that.invitationcol != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInvitation;
        result = 31 * result + (invitationText != null ? invitationText.hashCode() : 0);
        result = 31 * result + (invitationcol != null ? invitationcol.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idInvitedUser", referencedColumnName = "idUser", nullable = false)
    public UserEntity getUserByIdInvitedUser() {
        return userByIdInvitedUser;
    }

    public void setUserByIdInvitedUser(UserEntity userByIdInvitedUser) {
        this.userByIdInvitedUser = userByIdInvitedUser;
    }

    @ManyToOne
    @JoinColumn(name = "idInviter", referencedColumnName = "idUser", nullable = false)
    public UserEntity getUserByIdInviter() {
        return userByIdInviter;
    }

    public void setUserByIdInviter(UserEntity userByIdInviter) {
        this.userByIdInviter = userByIdInviter;
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
