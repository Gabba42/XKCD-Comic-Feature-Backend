package com.glisboa.slackfeature.controller;

import com.glisboa.slackfeature.model.Comic;
import com.glisboa.slackfeature.service.ComicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ComicController.class, secure=false)
public class ComicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ComicService comicService;

    Comic mockComic = new Comic(790, "2010", "Control", "Which, at one point, led to a study showing that LSD produces no more hallucinations than a placebo.", "https://imgs.xkcd.com/comics/control.png");
    String exampleComicJSON = "{\"num\":790,\"year\":\"2010\",\"title\":\"Control\",\"alt\":\"Which, at one point, led to a study showing that LSD produces no more hallucinations than a placebo.\",\"img\":\"https://imgs.xkcd.com/comics/control.png\"}";


    @Test
    public void getCurrentXKCDComic() throws Exception {
        Mockito.when(comicService.getCurrentComic()).thenReturn(mockComic);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/chat/messages/comic").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(exampleComicJSON))
                .andExpect(status().isOk());
    }

}

