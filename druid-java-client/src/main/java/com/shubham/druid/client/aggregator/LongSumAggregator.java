package com.shubham.druid.client.aggregator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.AggregationsType;

/**
 * Created by shubham.tyagi on 14/03/17.
 */
public class LongSumAggregator extends DruidAggregator {
    @JsonProperty("fieldName")
    private String fieldName;

    @JsonProperty("name")
    private String outputFieldName;

    LongSumAggregator() {
        super(AggregationsType.longSum);
    }

    public DruidAggregator setFields(String fieldName, String outputFieldName) {
        this.fieldName = fieldName;
        this.outputFieldName = outputFieldName;
        return this;
    }
}
