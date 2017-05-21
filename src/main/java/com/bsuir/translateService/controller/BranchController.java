package com.bsuir.translateService.controller;

import com.bsuir.translateService.dto.BranchDto;
import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Олег Пятко on 17.05.2017.
 */
@CrossOrigin
@RestController
public class BranchController extends BaseController{

    @RequestMapping(value = "/branch_list/")
    public ModelAndView showBranchList(HttpServletRequest request){
        UserEntity userEntity = getUserEntityFromToken(request);
        if (userEntity != null){
            Iterable<BranchDto> branchDto = branchService.getAllUsersTasks(userEntity.getIdUser());
            return BuildModelAndView("branch_list", "branches", branchDto);
        }
        return BuildModelAndView("redirect:/login");
    }

    private BranchService branchService;

    @Autowired
    public void setBranchService(BranchService branchService) {
        this.branchService = branchService;
    }
}
