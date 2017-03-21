package com.shubham.druid.client.aggregator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.AggregationsType;
import lombok.AllArgsConstructor;

/**
 * Created by shubham.tyagi on 14/03/17.
 */
@AllArgsConstructor
public class DruidAggregator {
    @JsonProperty("type")
    private AggregationsType aggregationsType;
}
