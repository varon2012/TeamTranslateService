package com.bsuir.translateService.dao.impl;

import com.bsuir.translateService.dao.InvitationRepository;
import com.bsuir.translateService.entity.InvitationEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@Repository
@Transactional
public class InvitationRepositoryImpl extends BaseRepository implements InvitationRepository {
    @Override
    public Iterable<InvitationEntity> findAll() {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from InvitationEntity ");
        Iterable<InvitationEntity> invitations = query.list();
        return invitations;
    }

    @Override
    public InvitationEntity findById(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from InvitationEntity u where u.idInvitation = :id");
        query.setParameter("id", id);
        List<InvitationEntity> list = query.list();
        if (list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Iterable<InvitationEntity> findByRepositoryId(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from InvitationEntity u where u.idRepository = :id");
        query.setParameter("id", id);
        List<InvitationEntity> list = query.list();
        return list;
    }

    @Override
    public Iterable<InvitationEntity> findByInviterId(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from InvitationEntity u where u.idInviter = :id");
        query.setParameter("id", id);
        List<InvitationEntity> list = query.list();
        return list;
    }

    @Override
    public Iterable<InvitationEntity> findByInvitedId(int id) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from InvitationEntity u where u.idInvitedUser = :id");
        query.setParameter("id", id);
        List<InvitationEntity> list = query.list();
        return list;
    }

    @Override
    public Iterable<InvitationEntity> findByIdRepositoryAndIsAccepted(int repId) {
        Session session = GetCurrentSession();
        Query query = session.createQuery("from InvitationEntity i where i.idRepository = :repId and i.isAccepted = 1");
        query.setParameter("repId", repId);
        List<InvitationEntity> list = query.list();
        return list;
    }

    @Override
    public void createInvitation(InvitationEntity invitationEntity) {
        Session session = GetCurrentSession();

        session.save(invitationEntity);
    }

    @Override
    public void updateInvitation(InvitationEntity invitationEntity) {
        Session session = GetCurrentSession();

        session.update(invitationEntity);
    }

    @Override
    public void deleteInvitation(InvitationEntity invitationEntity) {
        Session session = GetCurrentSession();

        session.delete(invitationEntity);
    }
}
