package com.technopreneur.strategy;

import com.technopreneur.model.RepoFiltersWeights;
import com.technopreneur.model.RepoSearchResponse;
import com.technopreneur.repository.dto.RepoResponse;

public interface FilterStrategy {

    RepoSearchResponse getFilteredResults(RepoResponse response, RepoFiltersWeights repoFiltersWeights, final int limit);
}
