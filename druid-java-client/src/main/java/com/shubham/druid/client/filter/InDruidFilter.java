package com.shubham.druid.client.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.FilterType;

import java.util.List;

/**
 * Created by shubham.tyagi on 10/03/17.
 */
public class InDruidFilter extends DruidFilter {
    @JsonProperty
    private String dimension;

    @JsonProperty
    private List<String> values;

    InDruidFilter(FilterType filterType) {
        super(FilterType.in);
    }

    public DruidFilter setFields(String dimension, List<String> values) {
        this.dimension = dimension;
        this.values = values;
        return this;
    }
}
