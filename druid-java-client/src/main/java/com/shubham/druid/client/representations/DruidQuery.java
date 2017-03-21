package com.shubham.druid.client.representations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubham.druid.client.aggregator.DruidAggregator;
import com.shubham.druid.client.filter.DruidFilter;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by shubham.tyagi on 05/03/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@ToString
public class DruidQuery {
    @JsonProperty
    private String queryType;

    @JsonProperty("dataSource")
    private String dataSource;

    @JsonProperty("granularity")
    private String granularity;

    @JsonProperty("filter")
    private DruidFilter filter;

    @JsonProperty("aggregations")
    private List<DruidAggregator> aggregations;

    @JsonProperty("intervals")
    private String intervals;

    public static class DruidQueryBuilder {
        private String queryType = "timeseries";
        private String dataSource;
        private String granularity = "day";
        private DruidFilter filter;
        private List<DruidAggregator> aggregations;
        private String intervals;
        private static final String INTERVAL_SEPARATOR = "/";

        public DruidQueryBuilder(String dataSource, DruidFilter filter, List<DruidAggregator> aggregations,
                                 long startTime, long endTime) {
            this.dataSource = dataSource;
            this.filter = filter;
            this.aggregations = aggregations;
            this.intervals = new DateTime(startTime).toString()
                    .concat(INTERVAL_SEPARATOR)
                    .concat(new DateTime(endTime).toString());
        }

        public DruidQueryBuilder setQueryType(String queryType) {
            this.queryType = queryType;
            return this;
        }

        public DruidQueryBuilder setGranularity(String granularity) {
            this.granularity = granularity;
            return this;
        }

        public DruidQuery build() {
            return new DruidQuery(queryType, dataSource, granularity, filter, aggregations, intervals);
        }
    }
}
