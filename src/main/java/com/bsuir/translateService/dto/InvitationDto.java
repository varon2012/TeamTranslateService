package com.bsuir.translateService.dto;

import com.bsuir.translateService.entity.InvitationEntity;
import com.bsuir.translateService.entity.RepositoryEntity;
import com.bsuir.translateService.entity.UserEntity;

/**
 * Created by Олег Пятко on 25.05.2017.
 */
public class InvitationDto {
    private UserEntity inviter;
    private RepositoryEntity repository;
    private InvitationEntity invitation;

    public UserEntity getInviter() {
        return inviter;
    }

    public void setInviter(UserEntity inviter) {
        this.inviter = inviter;
    }

    public RepositoryEntity getRepository() {
        return repository;
    }

    public void setRepository(RepositoryEntity repository) {
        this.repository = repository;
    }

    public InvitationEntity getInvitation() {
        return invitation;
    }

    public void setInvitation(InvitationEntity invitation) {
        this.invitation = invitation;
    }
}
