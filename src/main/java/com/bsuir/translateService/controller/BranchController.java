package com.bsuir.translateService.controller;

import com.bsuir.translateService.dto.BranchDto;
import com.bsuir.translateService.dto.LoginEntity;
import com.bsuir.translateService.dto.RepositoryListDto;
import com.bsuir.translateService.dto.TaskDto;
import com.bsuir.translateService.entity.BranchEntity;
import com.bsuir.translateService.entity.InvitationEntity;
import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.BranchService;
import com.bsuir.translateService.service.InvitationService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Олег Пятко on 17.05.2017.
 */
@CrossOrigin
@RestController
public class BranchController extends BaseController{

    @RequestMapping(value = "/branch_list")
    public ModelAndView showBranchList(HttpServletRequest request){
        UserEntity userEntity = getUserEntityFromToken(request);
        if (userEntity != null){
            Iterable<BranchDto> branchDto = branchService.getAllUsersTasks(userEntity.getIdUser());
            return BuildModelAndView("branch_list", "branches", branchDto);
        }
        return BuildModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/branch_list/{id}")
    public ModelAndView showBranchListByRep(@PathVariable(value = "id") int repId){
        Iterable<BranchEntity> branchEntities = branchService.findByRepositoryId(repId);
        List<RepositoryListDto> result = new ArrayList<>();
        for (BranchEntity branch : branchEntities) {
            UserEntity user = userService.findById(branch.getIdUser());
            RepositoryListDto rep = new RepositoryListDto();
            rep.setBranch(branch);
            rep.setUser(user);
            result.add(rep);
        }
        ModelAndView modelAndView = new ModelAndView("tasks_repository");
        modelAndView.addObject("branches", result);
        modelAndView.addObject("repId", repId);
        return modelAndView;
       // return BuildModelAndView("tasks_repository", "branches", result);
    }

    @RequestMapping(value = "/assign_task/{id}", method = RequestMethod.GET)
    public ModelAndView assignTaskPage(@PathVariable("id") int repId){
        TaskDto taskDto = new TaskDto();
        ModelAndView modelAndView = new ModelAndView("assign_task");
        List<InvitationEntity> invitationEntities = (List<InvitationEntity>) invitationService.findByRepIdAndIsAccepted(repId);
        //List<BranchEntity> branchEntities = (List<BranchEntity>) branchService.findByRepositoryId(repId);
        List<UserEntity> employees = new ArrayList<>();
        for (InvitationEntity invitationEntity: invitationEntities) {
            UserEntity userEntity = userService.findById(invitationEntity.getIdInvitedUser());
            employees.add(userEntity);
        }

        modelAndView.addObject("task", taskDto);
        modelAndView.addObject("users", employees);
        modelAndView.addObject("repId", repId);
        return modelAndView;
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.POST)
    public ModelAndView assignTask(@PathVariable("id") int repId, @ModelAttribute("task")TaskDto taskDto){
        BranchEntity task = new BranchEntity();
        task.setPlainText(taskDto.getPlainText());
        task.setName(taskDto.getName());
        task.setIsMainUser((byte)0);
        task.setIdRepository(repId);
        UserEntity user = userService.findByLogin(taskDto.getLogin());
        task.setIdUser(user.getIdUser());

        branchService.createBranch(task);
        ModelAndView modelAndView = new ModelAndView("redirect:/branch_list");
        return modelAndView;
       // return BuildModelAndView("redirect:/branch_list");
    }

    private InvitationService invitationService;
    private BranchService branchService;

    @Autowired
    public void setBranchService(BranchService branchService) {
        this.branchService = branchService;
    }

    @Autowired
    public void setInvitationService(InvitationService invitationService) {
        this.invitationService = invitationService;
    }
}
