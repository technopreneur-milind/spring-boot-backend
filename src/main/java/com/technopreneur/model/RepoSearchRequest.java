package com.technopreneur.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepoSearchRequest {
    private final int limit;
    private final RepoFiltersWeights weights;


    @JsonCreator
    public RepoSearchRequest(@JsonProperty("limit") final int limit,
                             @JsonProperty("weights") final RepoFiltersWeights weights) {
        this.limit = limit;
        this.weights = weights;
    }

    public int getLimit() {
        return limit;
    }

    public RepoFiltersWeights getWeights() {
        return weights;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("limit", limit)
                .add("weights", weights)
                .toString();
    }
}
