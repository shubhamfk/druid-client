package com.shubham.druid.client.provider;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by shubham.tyagi on 21/03/17.
 */
public class ClientProvider extends AbstractModule {
    protected void configure() {

    }

    @Provides
    @Singleton
    public Client getClient() {
        return ClientBuilder.newClient();
    }
}
