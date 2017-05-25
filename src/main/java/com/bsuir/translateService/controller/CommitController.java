package com.bsuir.translateService.controller;

import com.bsuir.translateService.dao.BranchRepository;
import com.bsuir.translateService.dao.CommitRepository;
import com.bsuir.translateService.dao.EmployeeRepository;
import com.bsuir.translateService.dto.CommitDto;
import com.bsuir.translateService.dto.CompareCommitsDto;
import com.bsuir.translateService.dto.CompareDto;
import com.bsuir.translateService.dto.TaskDto;
import com.bsuir.translateService.entity.BranchEntity;
import com.bsuir.translateService.entity.CommitEntity;
import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.BranchService;
import com.bsuir.translateService.service.CommitService;
import com.bsuir.translateService.utils.DiffAlgorithmString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Олег Пятко on 17.05.2017.
 */
@RestController
public class CommitController extends BaseController{

    @RequestMapping(value = "/new_commit/{id}", method = RequestMethod.GET)
    public ModelAndView addCommitPage(@PathVariable("id")int branchId){
        CommitEntity commitEntity = new CommitEntity();
        ModelAndView modelAndView = new ModelAndView("new_commit");
        modelAndView.addObject("commit", commitEntity);
        modelAndView.addObject("branchId", branchId);
        return modelAndView;
    }


    @RequestMapping(value = "/new_commit/{id}", method = RequestMethod.POST)
    public ModelAndView addCommit(@ModelAttribute("commit") CommitEntity commitEntity, @PathVariable("id") int branchId){
        commitEntity.setIdBranch(branchId);
        CommitEntity lastCommit = commitService.findLastCommitInBranch(branchId);
        if(lastCommit != null){
            commitEntity.setPreviousCommitId(lastCommit.getIdCommit());

        }
        commitService.createCommit(commitEntity);
        if (lastCommit != null){
            CommitEntity currentLast = commitService.findLastCommitInBranch(branchId);
            lastCommit.setNextCommitId(currentLast.getIdCommit());
            commitService.updateCommit(lastCommit);
        }

        return BuildModelAndView("redirect:/branch_list");
    }

    @RequestMapping(value = "/get_task/{id}", method = RequestMethod.GET)
    public ModelAndView showTaskTextPage(@PathVariable("id")int branchId){
        BranchEntity branchEntity = branchService.findById(branchId);
        String plainText = branchEntity.getPlainText();
        return BuildModelAndView("plain_text_page", "plainText", plainText);
    }

    @RequestMapping(value = "/commits/{id}", method = RequestMethod.GET)
    public ModelAndView commitsList(@PathVariable(value = "id") int id, HttpServletRequest request){
        Iterable<CommitDto> commits = commitService.getCommitList(id);
        CompareCommitsDto selectedCommits = new CompareCommitsDto();
        //selectedCommits.setBranchId(id);
        ModelAndView modelAndView = new ModelAndView("tasks_list");
        modelAndView.addObject("commits", commits);
        modelAndView.addObject("selectedCommits", selectedCommits);
        modelAndView.addObject("branchId", id);
        return modelAndView;
    }

    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    public ModelAndView comparePage(@ModelAttribute("selectedCommit")CompareCommitsDto commitsDto){
        CommitEntity commitEntity1 = commitService.findByHash(commitsDto.getCommit1());
        CommitEntity commitEntity2 = commitService.findByHash(commitsDto.getCommit2());
        if (commitEntity1 != null
                && commitEntity2 != null){
            DiffAlgorithmString diffAlgorithm = new DiffAlgorithmString(commitEntity1.getTranslatedText(), commitEntity2.getTranslatedText());
            BranchEntity branchEntity = branchService.findById(commitEntity1.getIdBranch());

            CompareDto compareDto = new CompareDto();
            compareDto.setPlainText(branchEntity.getPlainText());
            compareDto.setCompareResult(diffAlgorithm.getHtmlDiff());
            return BuildModelAndView("compare_commits", "compare", compareDto);
        }
        return BuildModelAndView("redirect:/branch_list");
    }

    @RequestMapping(value = "/commit/{id}", method = RequestMethod.GET)
    public ModelAndView getCommit(@PathVariable(value = "id") int commitId){
        CommitEntity commitEntity = commitService.findById(commitId);
        return BuildModelAndView("commit_page", "commit",commitEntity);
    }

    private BranchService branchService;
    private CommitService commitService;

    @Autowired
    public void setCommitRepository(CommitService commitService) {
        this.commitService = commitService;
    }

    @Autowired
    public void setBranchService(BranchService branchService) {
        this.branchService = branchService;
    }
}
