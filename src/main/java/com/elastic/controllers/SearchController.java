package com.elastic.controllers;


import com.elastic.ElasticSearch.ESService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;


/**
 * Created with IntelliJ IDEA.
 * User: idanf
 * Date: 09/03/14
 * Time: 17:15
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/search1")
public class SearchController {

    @Inject
    ESService esService;

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SearchController.class);

    @RequestMapping(value = "/term", method = RequestMethod.POST)
    @ResponseBody
    public String searchTerm(@RequestParam String termToSearch) {
        logger.debug("getting countries for language=" + termToSearch);
        return ("something");
    }

    @RequestMapping(value = "/ajaxcall", method = RequestMethod.GET)
    @ResponseBody
    public String search(String termToSearch) {
        logger.debug(termToSearch);
        return "hello " + termToSearch;
    }
}
