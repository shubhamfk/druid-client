package com.shubham.druid.client;

import com.shubham.druid.client.representations.DruidQuery;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by shubham.tyagi on 21/03/17.
 */
public class DruidClient {
    private Client client;
    private String url;

    public DruidClient(String url) {
        this.client = ClientBuilder
                        .newClient()
                        .register(DruidQuery.class);
        this.url = url;
    }

    public Response getResponse(DruidQuery query) {
        return client.target(url)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(query, MediaType.APPLICATION_JSON_TYPE));
    }
}
