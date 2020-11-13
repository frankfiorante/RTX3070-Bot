package com.frankfiorante.RTX3070Bot.service;

import com.frankfiorante.RTX3070Bot.error.KeywordNotFoundException;
import com.frankfiorante.RTX3070Bot.model.RTX3070BotResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RTX370StatusService {

    public RTX3070BotResponse findKeywordOnElement(String keyword, String elementSelector, String url) {
        RTX3070BotResponse response = RTX3070BotResponse.builder().build();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select(elementSelector);
            elements.forEach(element -> {
                if (element.text().equalsIgnoreCase(keyword)) {
                    response.setKeyWordFound(true);
                }
            });
            return response;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new KeywordNotFoundException(keyword);
        }
    }
}
