package com.technopreneur.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Repository {
    private final long id;
    private final String name;
    private final String url;
    private final long score;

    @JsonCreator
    public Repository(@JsonProperty("id") final long id,
                      @JsonProperty("name") final String name,
                      @JsonProperty("url") final String url,
                      @JsonProperty("score") final long score) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.score = score;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public long getScore() {
        return score;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Repository that = (Repository) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("url", url)
                .add("score", score)
                .toString();
    }
}
