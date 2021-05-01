package com.shipox.demo.mapper;

import com.shipox.demo.dto.TweetsDto;
import com.shipox.demo.model.Tweet;
import com.shipox.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TweetMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "content", ignore=true)
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    Tweet map(TweetsDto tweetsDto);

    @Mapping(target = "userName", expression = "java(tweet.getUser().getUsername())")
    TweetsDto mapToDto(Tweet tweet);
}
