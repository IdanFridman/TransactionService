package com.elastic.ElasticSearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

/**
 * Created by idanf on 08/07/2014.
 */
@Named
public class ESClient {
    Client client = null;



    @PostConstruct
    public void initClient() {
        System.out.println("testInit");
        client = new TransportClient()
            .addTransportAddress(new InetSocketTransportAddress("localhost", 9300))
            .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));

    }

    @PreDestroy
    public void shutDownClient() {
        System.out.println("Shutdown client");
        client.close();

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
