package com.shubham.druid.client.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.FilterType;
import lombok.RequiredArgsConstructor;

/**
 * Created by shubham.tyagi on 10/03/17.
 */
@RequiredArgsConstructor
public class DruidFilter {
    @JsonProperty("type")
    private final FilterType filterType;
}

