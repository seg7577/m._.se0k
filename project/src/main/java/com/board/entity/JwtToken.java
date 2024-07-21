package com.board.entity;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
//Bearer 방식
public class JwtToken {
    private String grantType;
    private String AccessToken;
    private String refreshToken;

}
