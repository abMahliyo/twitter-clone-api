package com.shipox.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TweetsDto {

    private Long id;
    private String content;
    private Instant createdDate;
    private String userName;
}
