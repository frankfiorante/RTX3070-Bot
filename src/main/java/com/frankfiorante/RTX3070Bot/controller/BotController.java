package com.frankfiorante.RTX3070Bot.controller;

import com.frankfiorante.RTX3070Bot.model.RTX3070BotResponse;
import com.frankfiorante.RTX3070Bot.service.RTX370StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    private RTX370StatusService service;

    @Autowired
    BotController(RTX370StatusService service) {
        this.service = service;
    }

    @GetMapping(value = "/status/keyWord/{keyWord}/elementSelector/{elementSelector}")
    public RTX3070BotResponse getRTX3070SalesStatus(
        @PathVariable String keyWord,
        @PathVariable String elementSelector,
        @RequestParam(value = "url") String url
    ) {
        return service.findKeywordOnElement(keyWord, elementSelector, url);
    }

}
