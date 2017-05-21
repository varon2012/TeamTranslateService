package com.bsuir.translateService.controller;

import com.bsuir.translateService.dao.BranchRepository;
import com.bsuir.translateService.dao.CommitRepository;
import com.bsuir.translateService.dao.EmployeeRepository;
import com.bsuir.translateService.dto.CommitDto;
import com.bsuir.translateService.dto.CompareCommitsDto;
import com.bsuir.translateService.dto.CompareDto;
import com.bsuir.translateService.entity.BranchEntity;
import com.bsuir.translateService.entity.CommitEntity;
import com.bsuir.translateService.service.BranchService;
import com.bsuir.translateService.service.CommitService;
import com.bsuir.translateService.utils.DiffAlgorithmString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.net.ssl.SSLSessionBindingEvent;
import java.util.List;

/**
 * Created by Олег Пятко on 17.05.2017.
 */
@RestController
public class CommitController extends BaseController{


    @RequestMapping(value = "/commits/{id}", method = RequestMethod.GET)
    public ModelAndView commitsList(@PathVariable(value = "id") int id){
        Iterable<CommitDto> commits = commitService.getCommitList(id);
        CompareCommitsDto selectedCommits = new CompareCommitsDto();
        //selectedCommits.setBranchId(id);
        ModelAndView modelAndView = new ModelAndView("tasks_list");
        modelAndView.addObject("commits", commits);
        modelAndView.addObject("selectedCommits", selectedCommits);
        return modelAndView;
    }

    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    public ModelAndView comparePage(@ModelAttribute("selectedCommit")CompareCommitsDto commitsDto){
        CommitEntity commitEntity1 = commitService.findByHash(commitsDto.getCommit1());
        CommitEntity commitEntity2 = commitService.findByHash(commitsDto.getCommit2());
        DiffAlgorithmString diffAlgorithm = new DiffAlgorithmString(commitEntity1.getTranslatedText(), commitEntity2.getTranslatedText());
        BranchEntity branchEntity = branchService.findById(commitEntity1.getIdBranch());

        CompareDto compareDto = new CompareDto();
        compareDto.setPlainText(branchEntity.getPlainText());
        compareDto.setCompareResult(diffAlgorithm.getHtmlDiff());
        return BuildModelAndView("compare_commits", "compare", compareDto);
    }

    @RequestMapping(value = "/commit/{id}", method = RequestMethod.GET)
    public ModelAndView getCommit(@PathVariable(value = "id") int commitId){
        CommitEntity commitEntity = commitService.findById(commitId);
        return BuildModelAndView("commit_page", "commit",commitEntity);
    }

    @RequestMapping(value = "/compare")
    public ModelAndView getComparePage(){
        DiffAlgorithmString diffAlgorithm = new DiffAlgorithmString("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut dignissim eu ligula ultricies laoreet. Aliquam erat volutpat. Sed nisl elit, commodo a interdum at, elementum nec leo. Aliquam mattis leo tempor, mattis purus a, laoreet mi. Vivamus non ullamcorper tortor, id consectetur nulla. Suspendisse potenti. Donec ullamcorper facilisis lacus, id pretium elit luctus sed. Nulla vitae molestie tellus. Cras orci massa, viverra at sodales in, tincidunt ac tellus. Maecenas maximus libero at massa euismod blandit non nec orci. Morbi ac sodales lorem. Nunc dictum a dui in sagittis. Donec malesuada metus consectetur purus sagittis sollicitudin sed pretium libero. Fusce maximus egestas purus. Quisque malesuada molestie justo, ac viverra dolor scelerisque nec.",
                "Lorem ipsum dolor sit ameta, consectetur adipiscing. Ut dignissim eu ligula ultricies. Aliquam erat volutpat. Sed nisl elit, commodo a interdum at, elementum nec leo? Aliquam mattis leo tempor, mattis purus a, laoreet mi. Vivamus non ullamcorper tortor, id consectetur nulla. Suspendisse potenti. Donec ullamcorper facilisis lacus, id pretium elit luctus sed. Nulla vitae molestie tellus. Cras orci massa, at sodales in, tincidunt ac tellus. Maecenas maximus libero at massa euismod blandit non nec orci. Morbi ac sodales lorem. Nunc dictum a dui in sagittis. Donec malesuada metus consectetur purus sagittis sollicitudin sed pretium libero. Fusce maximus egestas purus. Quisque malesuada molestie justo, ac viverra dolor scelerisque nec.Quisque malesuada molestie justo, ac viverra dolor scelerisque nec.");
        CompareDto compareDto = new CompareDto();
        compareDto.setPlainText("this is plain text");
        compareDto.setCompareResult(diffAlgorithm.getHtmlDiff());
        return BuildModelAndView("compare_commits", "compare", compareDto);
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
