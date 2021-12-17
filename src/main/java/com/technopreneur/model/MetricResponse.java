package com.technopreneur.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricResponse {
    private final List<MetricData> metricDataList;

    @JsonCreator
    public MetricResponse(@JsonProperty("metricDataList") final List<MetricData> metricDataList) {
        this.metricDataList = metricDataList;
    }

    public List<MetricData> getMetricDataList() {
        return metricDataList;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("metricDataList", metricDataList)
                .toString();
    }
}
