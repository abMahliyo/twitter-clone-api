package com.shipox.demo.repository;

import com.shipox.demo.model.Tweet;
import com.shipox.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

     List<Tweet> findByUser(User user);
}
