package com.shubham.druid.client.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.FilterType;

/**
 * Created by shubham.tyagi on 10/03/17.
 */
public class RegexFilter extends DruidFilter {
    @JsonProperty
    private String dimension;

    @JsonProperty
    private String pattern;

    RegexFilter(FilterType filterType) {
        super(FilterType.regex);
    }

    public DruidFilter setFields(String dimension, String pattern) {
        this.dimension = dimension;
        this.pattern = pattern;
        return this;
    }
}
