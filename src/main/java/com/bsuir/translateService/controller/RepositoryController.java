package com.bsuir.translateService.controller;

import com.bsuir.translateService.dto.CreateRepositoryDto;
import com.bsuir.translateService.dto.LoginEntity;
import com.bsuir.translateService.dto.RepositoryDto;
import com.bsuir.translateService.dto.TaskDto;
import com.bsuir.translateService.entity.BranchEntity;
import com.bsuir.translateService.entity.RepositoryEntity;
import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.BranchService;
import com.bsuir.translateService.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Олег Пятко on 22.05.2017.
 */
@CrossOrigin
@RestController
public class RepositoryController extends BaseController{

    @RequestMapping(value = "/repositories", method = RequestMethod.GET)
    public ModelAndView getUserRepositories(HttpServletRequest request){
        Iterable<BranchEntity> branchEntities = branchService.findByUserIdAndMainUser(getUserEntityFromToken(request).getIdUser());
        List<RepositoryDto> result = new ArrayList<>();
        for (BranchEntity entity :branchEntities  ) {
            RepositoryEntity repositoryEntity = repositoryService.findById(entity.getIdRepository());
            RepositoryDto dto = new RepositoryDto();
            dto.setEntity(repositoryEntity);
            List<BranchEntity> entities = (List<BranchEntity>) branchService.findByRepositoryId(repositoryEntity.getIdRepository());
            dto.setTasks(entities.size());
            result.add(dto);
        }
        return BuildModelAndView("repositories_list", "repositories", result);
    }

    @RequestMapping(value = "/new_repo", method = RequestMethod.GET)
    public ModelAndView newRepositoryPage(HttpServletRequest request){
        UserEntity userEntity = getUserEntityFromToken(request);
        if (userEntity != null){
            CreateRepositoryDto repositoryEntity = new CreateRepositoryDto();
            //return new ModelAndView("new_repository", "repoEntity", repositoryEntity);
            return BuildModelAndView("new_repository", "repoEntity", repositoryEntity);
        }
        return BuildModelAndView("login", "loginEntity", new LoginEntity());
    }

    @RequestMapping(value = "/new_repo", method = RequestMethod.POST)
    public ModelAndView newRepository(@ModelAttribute("repoEntity")CreateRepositoryDto repositoryDto, HttpServletRequest request){
        if (repositoryDto.getRepository().getName() != null){
            repositoryService.createRepository(repositoryDto.getRepository());
            RepositoryEntity createdRepo = repositoryService.findByName(repositoryDto.getRepository().getName());
            BranchEntity masterBranch = new BranchEntity();
            masterBranch.setIdRepository(createdRepo.getIdRepository());
            masterBranch.setIdUser(getUserEntityFromToken(request).getIdUser());
            masterBranch.setIsMainUser((byte)1);
            masterBranch.setName("master");
            masterBranch.setPlainText(repositoryDto.getPlainText());
            branchService.createBranch(masterBranch);
        }
        return BuildModelAndView("redirect:/branch_list");
    }

    private BranchService branchService;
    private RepositoryService repositoryService;

    @Autowired
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Autowired
    public void setBranchService(BranchService branchService) {
        this.branchService = branchService;
    }
}
