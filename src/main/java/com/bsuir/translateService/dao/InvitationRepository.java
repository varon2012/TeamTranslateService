package com.bsuir.translateService.dao;

import com.bsuir.translateService.entity.InvitationEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@org.springframework.stereotype.Repository
@Transactional
public interface InvitationRepository {
    Iterable<InvitationEntity> findAll();
    InvitationEntity findById(int id);
    Iterable<InvitationEntity> findByRepositoryId(int id);
    Iterable<InvitationEntity> findByInviterId(int id);
    Iterable<InvitationEntity> findByInvitedId(int id);
    Iterable<InvitationEntity> findByIdRepositoryAndIsAccepted(int repId);
    void createInvitation(InvitationEntity invitationEntity);
    void updateInvitation(InvitationEntity invitationEntity);
    void deleteInvitation(InvitationEntity invitationEntity);
}
