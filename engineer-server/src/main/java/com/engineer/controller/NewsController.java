package com.engineer.controller;

import com.engineer.entity.News;
import com.engineer.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NewsController {

        private final NewsRepository newsRepository;

        @GetMapping("/news")
        public News getNews() {
            News news = newsRepository.findOne(2L);
            return news;
        }

        @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/file")
        @ResponseStatus(HttpStatus.CREATED)
        void uploadStatementFile(@RequestParam("file") MultipartFile file) throws IOException {
            System.out.print(file);
            News news = new News();
            news.setSubject("Bieg na grochowsk");
            news.setContents("Chłopaki pobiegali");
            news.setTeammatePicture(file.getBytes());
            newsRepository.save(news);
        }
}
