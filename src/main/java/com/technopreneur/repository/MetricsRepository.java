package com.technopreneur.repository;

import com.technopreneur.model.Watch;
import com.technopreneur.repository.dto.MetricData;

import java.util.List;

public interface MetricsRepository {

    void recordHit(final String user, final String method);

    List<MetricData> getMetricData();
}
