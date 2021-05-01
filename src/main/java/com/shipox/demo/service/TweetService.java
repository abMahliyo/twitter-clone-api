package com.shipox.demo.service;

import com.shipox.demo.dto.TweetsDto;
import com.shipox.demo.exceptions.TwitterCloneException;
import com.shipox.demo.exceptions.TwitterNotFoundException;
import com.shipox.demo.mapper.TweetMapper;
import com.shipox.demo.model.Tweet;
import com.shipox.demo.repository.TweetRepository;
import com.shipox.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final TweetMapper tweetMapper;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;


    @Transactional
    public TweetsDto save(TweetsDto tweetsDto) {
        Tweet tweet = tweetRepository.save(tweetMapper.map(tweetsDto));
        tweetsDto.setId(tweet.getId());
        return tweetsDto;
    }

    @Transactional
    public List<TweetsDto> getAll() {
        return tweetRepository.findAll()
                .stream()
                .map(tweetMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public TweetsDto getTweet(Long id) {
        Tweet tweet = tweetRepository.findById(id)
                .orElseThrow(()-> new TwitterCloneException("There is not tweet with ID " + id));
        return tweetMapper.mapToDto(tweet);
    }

}
