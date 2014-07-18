package com.elastic.ElasticSearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by idanf on 14/07/2014.
 */
@Named
public class ESService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    ESOperations esOperations;

    public List<Object> searchTerm(String searchTerm) {
        List<Object> result = esOperations.searchTerm(searchTerm);
        return result;

    }



}
