package com.technopreneur.repository.dto;

import com.google.common.base.MoreObjects;

import java.util.List;

public class MetricData {
    private final String user;
    private final List<Metric> metrics;

    public MetricData(final String user, final List<Metric> metrics) {
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
