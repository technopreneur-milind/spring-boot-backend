package com.technopreneur.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.technopreneur.repository.dto.Metric;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricData {
    private final String user;
    private final List<Metric> metrics;

    @JsonCreator
    public MetricData(@JsonProperty("user") final String user,
                      @JsonProperty("metrics") final List<Metric> metrics) {
        this.user = user;
        this.metrics = metrics;
    }

    public String getUser() {
        return user;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("user", user)
                .add("metrics", metrics)
                .toString();
    }
}
