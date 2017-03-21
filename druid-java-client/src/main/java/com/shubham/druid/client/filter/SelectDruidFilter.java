package com.shubham.druid.client.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.FilterType;
import lombok.ToString;

/**
 * Created by shubham.tyagi on 10/03/17.
 */
@ToString
public class SelectDruidFilter extends DruidFilter {
    @JsonProperty
    private String dimension;

    @JsonProperty
    private String value;

    SelectDruidFilter() {
        super(FilterType.selector);
    }

    public DruidFilter setQueryValues(String dimension, String value) {
        this.dimension = dimension;
        this.value = value;
        return this;
    }
}
