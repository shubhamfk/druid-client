package com.shubham.druid.client.aggregator;

/**
 * Created by shubham.tyagi on 14/03/17.
 */
public class DruidQueryAggregator {
    public static HyperUniqueAggregator hyperUnique() {
        return new HyperUniqueAggregator();
    }

    public static LongMaxAggregator longMax() {
        return new LongMaxAggregator();
    }

    public static LongMinAggregator longMin() {
        return new LongMinAggregator();
    }

    public static DoubleMaxAggregator doubleMax() {
        return new DoubleMaxAggregator();
    }

    public static DoubleMinAggregator doubleMin() {
        return new DoubleMinAggregator();
    }

    public static LongSumAggregator longSum() {
        return new LongSumAggregator();
    }

    public static DoubleSumAggregator doubleSum() { return new DoubleSumAggregator(); }

    public static CountAggregator count() { return new CountAggregator(); }

}
