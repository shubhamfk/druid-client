package com.shubham.druid.client.aggregator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.AggregationsType;

/**
 * Created by shubham.tyagi on 14/03/17.
 */
public class LongMinAggregator extends DruidAggregator {
    @JsonProperty("fieldName")
    private String fieldName;

    @JsonProperty("name")
    private String outputFieldName;

    LongMinAggregator() {
        super(AggregationsType.longMin);
    }

    public DruidAggregator setFields(String fieldName, String outputFieldName) {
        this.fieldName = fieldName;
        this.outputFieldName = outputFieldName;
        return this;
    }
}
