package com.elastic.ElasticSearch;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by idanf on 10/07/2014.
 */

@Named
public class ESOperations {

    public static final String INDEX_NAME = "mycompany";
    public static final String TYPE_NAME = "login";
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Inject
    ESClient esClient;



    public void index() throws IOException {
        IndexResponse response = esClient.getClient().prepareIndex(INDEX_NAME, TYPE_NAME)
            .setSource(XContentFactory.jsonBuilder()
                    .startObject()
                    .field("username", "Jossef")
                    .field("location", "Israel")
                    .field("date", new Date())
                    .endObject()
            )
            .execute()
            .actionGet();
    }

    public void bulkIndexing() {

    }

    public List<Object> searchTerm(String searchTerm) {
        SearchResponse response = esClient.getClient().prepareSearch(INDEX_NAME)
            .setTypes(TYPE_NAME)
            .setSearchType(SearchType.DEFAULT)
            .setQuery(QueryBuilders.queryString(searchTerm))             // Query
                // .setPostFilter(FilterBuilders.rangeFilter("age").from(12).to(18))   // Filter
            .setFrom(0).setSize(60).setExplain(true)
            .execute()
            .actionGet();


        SearchHit[] docs = response.getHits().getHits();
        log.info("Number of docs=" + String.valueOf(docs.length));


        List<Object> result = Arrays.asList(response.getHits().getHits()).stream().
            map(hit -> new HashMap<String, Object>(hit.getSource())).collect(Collectors.toList());

        log.info("results=" + result.toString());
        return result;



        // Map<String, Object> source = hit.getSource();


    }

}
