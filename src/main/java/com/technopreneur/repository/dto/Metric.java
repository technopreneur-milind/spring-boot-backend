package com.technopreneur.repository.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Metric {
    private final String method;
    private final String dateTime;

    @JsonCreator
    public Metric(@JsonProperty("method") final String method,
                  @JsonProperty("dateTime") final String dateTime) {
        this.method = method;
        this.dateTime = dateTime;
    }

    public String getMethod() {
        return method;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("method", method)
                .add("dateTime", dateTime)
                .toString();
    }
}
