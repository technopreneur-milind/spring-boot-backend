package com.technopreneur.repository;

import com.technopreneur.model.Watch;
import com.technopreneur.repository.dto.Metric;
import com.technopreneur.repository.dto.MetricData;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class MetricsRepositoryImpl implements MetricsRepository {
    //In Memory store
    private Map<String, List<Metric>> metricStore = new ConcurrentHashMap<>();

    @Override
    public void recordHit(final String user, final String method) {
        Metric metric = new Metric(method, DateTime.now().toString());
        if (!metricStore.containsKey(user)) {
            List<Metric> metricList = new ArrayList<>();
            metricList.add(metric);
            metricStore.put(user, metricList);
        } else {
            List<Metric> metricList = metricStore.get(user);
            metricList.add(metric);
        }
    }

    public List<MetricData> getMetricData() {
        return metricStore.entrySet().stream().map(e -> new MetricData(e.getKey(), e.getValue())).collect(Collectors.toList());
    }
}
