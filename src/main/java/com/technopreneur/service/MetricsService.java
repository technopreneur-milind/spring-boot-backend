package com.technopreneur.service;

import com.technopreneur.model.MetricResponse;
import com.technopreneur.model.Watch;

public interface MetricsService {
    void record(final String user, final String method);
    MetricResponse getMetricData();
}
