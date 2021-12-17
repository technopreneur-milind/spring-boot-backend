package com.technopreneur.service;

import com.technopreneur.model.RepoFiltersWeights;
import com.technopreneur.model.RepoSearchRequest;
import com.technopreneur.model.RepoSearchResponse;

public interface RepoSearchService {

    RepoSearchResponse searchRepository(RepoFiltersWeights repoFiltersWeights);
}
