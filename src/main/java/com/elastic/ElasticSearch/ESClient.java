package com.elastic.ElasticSearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

/**
 * Created by idanf on 08/07/2014.
 */
@Named
public class ESClient {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    Client client = null;



    @PostConstruct
    public void initClient() {
        log.info("init ES client");
        client = new TransportClient()
            .addTransportAddress(new InetSocketTransportAddress("localhost", 9300))
            .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));

    }

    @PreDestroy
    public void shutDownClient() {
        log.info("Shutdown ES client");
        client.close();

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
