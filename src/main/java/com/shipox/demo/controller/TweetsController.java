package com.shipox.demo.controller;

import com.shipox.demo.dto.TweetsDto;
import com.shipox.demo.model.Tweet;
import com.shipox.demo.service.TweetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/tweets")
public class TweetsController {

    private final TweetService tweetService;

    @PostMapping
    public ResponseEntity<TweetsDto> createTweet(@RequestBody TweetsDto tweetsDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tweetService.save(tweetsDto));
    }

    @GetMapping
    public ResponseEntity<List<TweetsDto>> getAllTweets() {
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(tweetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TweetsDto> getTweet(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tweetService.getTweet(id));
    }

}
