package com.glisboa.slackfeature.service;

import com.glisboa.slackfeature.SlackfeatureApplication;
import com.glisboa.slackfeature.model.Comic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComicService {

    private static final Logger log = LoggerFactory.getLogger(SlackfeatureApplication.class);
    private static final RestTemplate restTemplate = new RestTemplate();
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {
//        return args -> {
//            Comic comic = restTemplate.getForObject(
//                    "https://xkcd.com/info.0.json", Comic.class);
//            log.info(comic.toString());
//        };
//    }

    public Comic getCurrentComic() {
        Comic comic = restTemplate.getForObject(
                "https://xkcd.com/info.0.json", Comic.class);
        log.info(comic.toString());
        return comic;
    }
}

