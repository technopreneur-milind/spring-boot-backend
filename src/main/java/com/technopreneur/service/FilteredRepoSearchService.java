package com.technopreneur.service;

import com.technopreneur.exceptions.RepoSearchException;
import com.technopreneur.model.RepoFiltersWeights;
import com.technopreneur.model.RepoSearchRequest;
import com.technopreneur.model.RepoSearchResponse;
import com.technopreneur.repository.GitHubRepository;
import com.technopreneur.strategy.FilterStrategy;
import org.springframework.stereotype.Service;

@Service
public class FilteredRepoSearchService implements RepoSearchService {

    private static final int LIMIT = 25;
    private final GitHubRepository gitHubRepository;
    private final FilterStrategy filterStrategy;

    public FilteredRepoSearchService(final GitHubRepository gitHubRepository, final FilterStrategy filterStrategy) {
        this.gitHubRepository = gitHubRepository;
        this.filterStrategy = filterStrategy;
    }

    public RepoSearchResponse searchRepository(final RepoFiltersWeights repoFiltersWeights) {
        return this.gitHubRepository.search()
                .map(repoResponse -> filterStrategy.getFilteredResults(repoResponse,repoFiltersWeights, LIMIT)) //should have its own version of RepoFiltersWeights
                .orElseThrow(() -> new RepoSearchException("Failed to do a github search"));
    }
}
