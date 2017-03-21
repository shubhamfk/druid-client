package com.shubham.druid.client.filter;

/**
 * Created by shubham.tyagi on 10/03/17.
 */
public class DruidQueryFilter {
    public static AndDruidFilter and() {
        return new AndDruidFilter();
    }

    public static SelectDruidFilter select() {
        return new SelectDruidFilter();
    }

    public static NotDruidFilter not() {
        return new NotDruidFilter();
    }

    public static OrDruidFilter or() {
        return new OrDruidFilter();
    }
}
