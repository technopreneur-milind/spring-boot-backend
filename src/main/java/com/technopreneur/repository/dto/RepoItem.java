package com.technopreneur.repository.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepoItem {
    private final long id;
    private final String name;
    private final long watchers;
    private final String lanuage;
    private final long forks;
    private final long openIssues;
    private final long size;
    private final String updatedAt;
    private final String url;


    @JsonCreator
    public RepoItem(@JsonProperty("id") final long id,
                    @JsonProperty("name") final String name,
                    @JsonProperty("watchers") final long watchers,
                    @JsonProperty("lanuage") final String lanuage,
                    @JsonProperty("forks") final long forks,
                    @JsonProperty("open_issues") final long openIssues,
                    @JsonProperty("size") final long size,
                    @JsonProperty("updated_at") final String updatedAt,
                    @JsonProperty("url") final String url) {
        this.id = id;
        this.name = name;
        this.watchers = watchers;
        this.lanuage = lanuage;
        this.forks = forks;
        this.openIssues = openIssues;
        this.size = size;
        this.updatedAt = updatedAt;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getWatchers() {
        return watchers;
    }

    public String getLanuage() {
        return lanuage;
    }

    public long getForks() {
        return forks;
    }

    public long getOpenIssues() {
        return openIssues;
    }

    public long getSize() {
        return size;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("watchers", watchers)
                .add("lanuage", lanuage)
                .add("forks", forks)
                .add("openIssues", openIssues)
                .add("size", size)
                .add("updatedAt", updatedAt)
                .add("url", url)
                .toString();
    }
}
