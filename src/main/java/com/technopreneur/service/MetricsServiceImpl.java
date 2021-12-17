package com.technopreneur.service;

import com.technopreneur.model.MetricData;
import com.technopreneur.model.MetricResponse;
import com.technopreneur.model.Watch;
import com.technopreneur.repository.MetricsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MetricsServiceImpl implements MetricsService {

    private final MetricsRepository metricsRepository;

    public MetricsServiceImpl(final MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    @Override
    public void record(final String user, final String method) {
        Objects.requireNonNull(user);
        Objects.requireNonNull(method);
        metricsRepository.recordHit(user, method);
    }

    public MetricResponse getMetricData() {
        List<MetricData> metricDataList = metricsRepository.getMetricData().stream().map(e -> new MetricData(e.getUser(), e.getMetrics())).collect(Collectors.toList());
        return new MetricResponse(metricDataList);
    }
}
