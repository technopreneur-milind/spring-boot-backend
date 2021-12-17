package com.technopreneur.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepoFiltersWeights {
    private int forkCountWeight;
    private int watchersWeight;
    private int openIssuesWeight;
    private int oddOwnerWeight;
    private int sizeWeight;
    private int javaLanguageWeight;
    private int recentlyUpdatedWeight;

    public RepoFiltersWeights() {
    }

    @JsonCreator
    public RepoFiltersWeights(@JsonProperty("forkCountWeight") final int forkCountWeight,
                              @JsonProperty("watchersWeight") final int watchersWeight,
                              @JsonProperty("openIssuesWeight") final int openIssuesWeight,
                              @JsonProperty("oddOwnerWeight") final int oddOwnerWeight,
                              @JsonProperty("sizeWeight") final int sizeWeight,
                              @JsonProperty("javaLanguageWeight") final int javaLanguageWeight,
                              @JsonProperty("recentlyUpdatedWeight") final int recentlyUpdatedWeight) {
        this.forkCountWeight = forkCountWeight;
        this.watchersWeight = watchersWeight;
        this.openIssuesWeight = openIssuesWeight;
        this.oddOwnerWeight = oddOwnerWeight;
        this.sizeWeight = sizeWeight;
        this.javaLanguageWeight = javaLanguageWeight;
        this.recentlyUpdatedWeight = recentlyUpdatedWeight;
    }

    public void setForkCountWeight(final int forkCountWeight) {
        this.forkCountWeight = forkCountWeight;
    }

    public void setWatchersWeight(final int watchersWeight) {
        this.watchersWeight = watchersWeight;
    }

    public void setOpenIssuesWeight(final int openIssuesWeight) {
        this.openIssuesWeight = openIssuesWeight;
    }

    public void setOddOwnerWeight(final int oddOwnerWeight) {
        this.oddOwnerWeight = oddOwnerWeight;
    }

    public void setSizeWeight(final int sizeWeight) {
        this.sizeWeight = sizeWeight;
    }

    public void setJavaLanguageWeight(final int javaLanguageWeight) {
        this.javaLanguageWeight = javaLanguageWeight;
    }

    public void setRecentlyUpdatedWeight(final int recentlyUpdatedWeight) {
        this.recentlyUpdatedWeight = recentlyUpdatedWeight;
    }

    public int getForkCountWeight() {
        return forkCountWeight;
    }

    public int getWatchersWeight() {
        return watchersWeight;
    }

    public int getOpenIssuesWeight() {
        return openIssuesWeight;
    }

    public int getOddOwnerWeight() {
        return oddOwnerWeight;
    }

    public int getSizeWeight() {
        return sizeWeight;
    }

    public int getJavaLanguageWeight() {
        return javaLanguageWeight;
    }

    public int getRecentlyUpdatedWeight() {
        return recentlyUpdatedWeight;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("forkCountWeight", forkCountWeight)
                .add("watchersWeight", watchersWeight)
                .add("openIssuesWeight", openIssuesWeight)
                .add("oddOwnerWeight", oddOwnerWeight)
                .add("sizeWeight", sizeWeight)
                .add("javaLanguageWeight", javaLanguageWeight)
                .add("recentlyUpdatedWeight", recentlyUpdatedWeight)
                .toString();
    }
}
