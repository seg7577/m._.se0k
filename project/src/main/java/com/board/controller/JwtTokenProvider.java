package com.board.controller;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@Slf4j
public class JwtTokenProvider {
    private final Key key;

  public JwtTokenProvider(@Value("${JwtToken}")) {}

}
