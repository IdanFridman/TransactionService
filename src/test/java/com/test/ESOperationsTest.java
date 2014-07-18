package com.test;

import com.elastic.ElasticSearch.ESOperations;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

/**
 * Created by idanf on 08/07/2014.
 */
public class ESOperationsTest extends CommonServicesAbstractTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Inject
    ESOperations elasticIndexing;


    @Test
    public void test() {
        System.out.println("test111");

    }

    @Test
    public void insertNewDoc() throws IOException {
        elasticIndexing.index();


    }

    @Test
    public void queryDoc() throws IOException {
        List<Object> result = elasticIndexing.searchTerm("CDATA");
        result.stream().forEach(item -> log.info(item.toString()));
        int z=0;
        z++;
    }


}
