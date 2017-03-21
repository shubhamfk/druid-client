package com.shubham.druid.client.aggregator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.AggregationsType;

/**
 * Created by shubham.tyagi on 14/03/17.
 */
public class CountAggregator extends DruidAggregator {

    @JsonProperty("name")
    private String outputFieldName;

    CountAggregator() {
        super(AggregationsType.count);
    }
    
    public DruidAggregator setFields(String outputFieldName) {
        this.outputFieldName = outputFieldName;
        return this;
    }

}
