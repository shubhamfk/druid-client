package com.shubham.druid.client.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.FilterType;
import lombok.ToString;

/**
 * Created by shubham.tyagi on 10/03/17.
 */
@ToString
public class NotDruidFilter extends DruidFilter {
    @JsonProperty("field")
    private DruidFilter filter;

    NotDruidFilter() {
        super(FilterType.not);
    }

    public DruidFilter addFilter(DruidFilter filter) {
        this.filter = filter;
        return this;
    }
}
