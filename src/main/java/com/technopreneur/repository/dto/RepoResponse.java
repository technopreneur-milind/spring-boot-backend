package com.technopreneur.repository.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepoResponse {
    private final String total_count;
    private final Boolean incomplete_results;
    private final List<RepoItem> items;

    @JsonCreator
    public RepoResponse(@JsonProperty("total_count") final String total_count,
                        @JsonProperty("incomplete_results") final Boolean incomplete_results,
                        @JsonProperty("items") final List<RepoItem> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public String getTotal_count() {
        return total_count;
    }

    public Boolean getIncomplete_results() {
        return incomplete_results;
    }

    public List<RepoItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("total_count", total_count)
                .add("incomplete_results", incomplete_results)
                .add("items", items)
                .toString();
    }
}
