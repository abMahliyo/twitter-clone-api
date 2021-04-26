package com.shipox.demo.controller;

import com.shipox.demo.model.Tweet;
import com.shipox.demo.model.User;
import com.shipox.demo.repository.TweetRepository;
import com.shipox.demo.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/tweets")
    public List<Tweet> index() {
        return tweetRepository.findAll();
    }

    @GetMapping("/tweets/{id}")
    public Tweet show(@PathVariable String id) {
        int tweetId = Integer.parseInt(id);
        return tweetRepository.getOne(tweetId);
    }

    @PostMapping("/tweets/search")
    public List<Tweet> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("con");
        return tweetRepository.findByTweetUserContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/tweets")
    public Tweet create(@RequestBody Map<User, String> body) {
        String  tweetUser = body.get("tweetUser");
        String content = body.get("content");
        return tweetRepository.save(new Tweet(tweetUser, content));
    }

    @PutMapping("/tweets/{id}")
    public Tweet update(@PathVariable String Id, @RequestBody Map<String, String> body) {
        int  id = Integer.parseInt(Id);
        Tweet tweet = tweetRepository.getOne(id);
        tweet.setTweetUser(body.get("tweetUser"));
    }



    }
