package com.board.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//기본 키가 데이터베이스에 의해 자동으로 생성되도록함. 'IDENTITY' 전략은 보통 mysql에서 'AUTO_INCREMENT'를 사용하여 기본 키를 생성함
    private Long id;
    private String e_mail;
    private String password;
    private String nickname;
    private String year;
    private String month;
    private String day;
    private int gen; //0이면 여자 1이면 남자
}
