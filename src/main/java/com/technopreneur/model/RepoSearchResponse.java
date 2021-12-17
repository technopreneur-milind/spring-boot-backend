package com.technopreneur.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepoSearchResponse {
    private final List<Repository> repositories;

    @JsonCreator
    public RepoSearchResponse(@JsonProperty("repositories") final List<Repository> repositories) {
        this.repositories = repositories;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("repositories", repositories)
                .toString();
    }
}
