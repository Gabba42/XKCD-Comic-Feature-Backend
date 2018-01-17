package com.glisboa.slackfeature.controller;

import com.glisboa.slackfeature.model.Comic;
import com.glisboa.slackfeature.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/messages")
@CrossOrigin("http://localhost:4200")
public class ComicController {

    @Autowired
    ComicService comicService;

    @GetMapping("/comic")
    public ResponseEntity<Comic> getCurrentXKCDComic() {
        Comic comic = comicService.getCurrentComic();
        if (comic == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comic, HttpStatus.OK);
    }
}
