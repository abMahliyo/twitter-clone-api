package com.shipox.demo.repository;

import com.shipox.demo.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

    List<Tweet> findByTweetUserContainingOrContentContaining(String tweetUs, String con);
}
