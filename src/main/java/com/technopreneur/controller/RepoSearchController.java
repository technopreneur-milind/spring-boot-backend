package com.technopreneur.controller;

import com.technopreneur.model.RepoFiltersWeights;
import com.technopreneur.model.RepoSearchRequest;
import com.technopreneur.model.RepoSearchResponse;
import com.technopreneur.service.RepoSearchService;
import com.technopreneur.util.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.management.relation.Role;

import static com.technopreneur.util.Utils.isAdmin;

@Controller
@RequestMapping("/v1")
public class RepoSearchController {
    private final RepoSearchService repoSearchService;

    public RepoSearchController(final RepoSearchService repoSearchService) {
        this.repoSearchService = repoSearchService;
    }

    @PostMapping(value = "/search")
    public String searchRepositories(@ModelAttribute("repoFiltersWeights") final RepoFiltersWeights repoFiltersWeights, final Model model,
                                     final Authentication authentication) {
        RepoSearchResponse repoSearchResponse = repoSearchService.searchRepository(repoFiltersWeights);
        if (isAdmin(authentication)) {
            model.addAttribute("admin", "true");
        }
        model.addAttribute("response", repoSearchResponse);
        return "result";
    }

    @GetMapping(value = "/form")
    public String getSearchForm(final Model model, final Authentication authentication) {
        model.addAttribute("repoFiltersWeights", new RepoFiltersWeights());
        if (isAdmin(authentication)) {
            model.addAttribute("admin", "true");
        }
        return "form";
    }
}
