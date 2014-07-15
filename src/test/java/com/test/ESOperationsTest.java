package com.test;

import com.cellebrite.ElasticSearch.ESOperations;
import org.junit.Test;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by idanf on 08/07/2014.
 */
public class ESOperationsTest extends CommonServicesAbstractTest{

    @Inject
    ESOperations elasticIndexing;


    @Test
    public void test()
    {
        System.out.println("test111");

    }

    @Test
    public void insertNewDoc() throws IOException {
        elasticIndexing.index();


    }

    @Test
    public void queryDoc() throws IOException {
        elasticIndexing.search();


    }
}
