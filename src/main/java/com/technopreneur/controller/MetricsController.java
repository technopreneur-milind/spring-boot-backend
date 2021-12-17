package com.technopreneur.controller;

import com.technopreneur.model.MetricResponse;
import com.technopreneur.service.MetricsService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.technopreneur.util.Utils.isAdmin;

@Controller
@RequestMapping("/v1")
public class MetricsController {
    private final MetricsService metricsService;

    public MetricsController(final MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping("/metrics")
    public String getMetricData(final Model model, final Authentication authentication) {
        final MetricResponse metricData = metricsService.getMetricData();
        if (isAdmin(authentication)) {
            model.addAttribute("admin", "true");
        }
        model.addAttribute("metrics", metricData);
        return "metrics";
    }
}
