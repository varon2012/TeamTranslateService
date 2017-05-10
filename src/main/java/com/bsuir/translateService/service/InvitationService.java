package com.bsuir.translateService.service;

import com.bsuir.translateService.dao.InvitationRepository;
import com.bsuir.translateService.entity.InvitationEntity;
import com.bsuir.translateService.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Олег Пятко on 10.05.2017.
 */
@Service
public class InvitationService {
    public Iterable<InvitationEntity> findAll(){
        return invitationRepository.findAll();
    }

    public InvitationEntity findById(int id){
        InvitationEntity entity = invitationRepository.findById(id);

        if (entity == null){
            throw new ServiceException("invitation with id :" + id + " not found");
        }

        return entity;
    }

    public Iterable<InvitationEntity> findByInviterId(int id){
        return invitationRepository.findByInviterId(id);
    }

    public Iterable<InvitationEntity> findByInvitedId(int id){
        return invitationRepository.findByInvitedId(id);
    }

    public Iterable<InvitationEntity> findByRepositoryId(int id){
        return invitationRepository.findByRepositoryId(id);
    }

    private InvitationRepository invitationRepository;

    @Autowired
    public void setInvitationRepository(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }
}
