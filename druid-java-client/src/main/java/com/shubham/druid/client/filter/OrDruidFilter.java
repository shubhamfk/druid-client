package com.shubham.druid.client.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.representations.FilterType;
import lombok.ToString;

import java.util.List;

/**
 * Created by shubham.tyagi on 10/03/17.
 */
@ToString
public class OrDruidFilter extends DruidFilter {
    @JsonProperty("fields")
    private List<DruidFilter> filterList;

    OrDruidFilter() {
        super(FilterType.or);
    }

    public DruidFilter addFilterList(List<DruidFilter> druidFilterList) {
        this.filterList = druidFilterList;
        return this;
    }
}
