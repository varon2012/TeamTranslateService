package com.bsuir.translateService.controller;

import com.bsuir.translateService.dao.Repository;
import com.bsuir.translateService.dto.InvitationDto;
import com.bsuir.translateService.dto.InviteDto;
import com.bsuir.translateService.entity.BranchEntity;
import com.bsuir.translateService.entity.InvitationEntity;
import com.bsuir.translateService.entity.RepositoryEntity;
import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.BranchService;
import com.bsuir.translateService.service.InvitationService;
import com.bsuir.translateService.service.RepositoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Олег Пятко on 22.05.2017.
 */
@CrossOrigin
@RestController
public class InvitationController extends BaseController{

    @RequestMapping(value = "/invites", method = RequestMethod.GET)
    public ModelAndView showInvitePage(HttpServletRequest request){
        UserEntity currentUser = getUserEntityFromToken(request);
        List<InvitationEntity> invitationEntities = (List<InvitationEntity>) invitationService.findByInvitedId(currentUser.getIdUser());
        List<InvitationDto> dtos = new ArrayList<>();
        for (InvitationEntity invitation: invitationEntities) {
            if (invitation.getIsAccepted() == 0){
                InvitationDto invitationDto = new InvitationDto();
                RepositoryEntity repositoryEntity = repositoryService.findById(invitation.getIdRepository());
                UserEntity inviter = userService.findById(invitation.getIdInviter());
                invitationDto.setInvitation(invitation);
                invitationDto.setInviter(inviter);
                invitationDto.setRepository(repositoryEntity);
                dtos.add(invitationDto);
            }
        }
        return BuildModelAndView("invites", "invites", dtos);
    }

    @RequestMapping(value = "/accept_invite/{id}", method = RequestMethod.POST)
    public ModelAndView acceptInvite(@PathVariable("id")int invitationId){
        InvitationEntity invitationEntity = invitationService.findById(invitationId);
        invitationEntity.setIsAccepted((byte)1);
        invitationService.update(invitationEntity);
        return BuildModelAndView("redirect:/invites");
    }

    @RequestMapping(value = "/invite", method = RequestMethod.GET)
    public ModelAndView showInvitationPage(HttpServletRequest request){
        UserEntity currentUser = getUserEntityFromToken(request);
        InviteDto inviteDto = new InviteDto();
        List<BranchEntity> branchEntities = (List<BranchEntity>)branchService.findByUserIdAndMainUser(currentUser.getIdUser());
        List<RepositoryEntity> repositoryEntities = new ArrayList<>();
        for (BranchEntity branchEntity: branchEntities) {
            RepositoryEntity repositoryEntity = repositoryService.findById(branchEntity.getIdRepository());
            repositoryEntities.add(repositoryEntity);
        }
        ModelAndView modelAndView = new ModelAndView("invite_page");
        modelAndView.addObject("repositories",repositoryEntities);
        modelAndView.addObject("invite", inviteDto);
        return modelAndView;
        //return BuildModelAndView("invite_page", "invite",  inviteDto);
    }

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    public ModelAndView sendInvite(@ModelAttribute("invite")InviteDto inviteDto, HttpServletRequest request){
        UserEntity currentUser = getUserEntityFromToken(request);
        UserEntity invitedUser = userService.findByLogin(inviteDto.getLogin());
        if (invitedUser != null){
            RepositoryEntity repositoryEntity = repositoryService.findByName(inviteDto.getRepName());
            InvitationEntity invitationEntity = new InvitationEntity();
            invitationEntity.setIsAccepted((byte)0);
            invitationEntity.setIdInvitedUser(invitedUser.getIdUser());
            invitationEntity.setIdInviter(currentUser.getIdUser());
            invitationEntity.setIdRepository(repositoryEntity.getIdRepository());
            invitationEntity.setInvitationText(inviteDto.getMessage());
            invitationService.create(invitationEntity);
        }
        return BuildModelAndView("redirect:/invites");
    }

    private InvitationService invitationService;
    private RepositoryService repositoryService;
    private BranchService branchService;

    @Autowired
    public void setInvitationService(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @Autowired
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Autowired
    public void setBranchService(BranchService branchService) {
        this.branchService = branchService;
    }
}
