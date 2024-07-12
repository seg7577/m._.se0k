package com.board.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Member")
public class Member {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//기본 키가 데이터베이스에 의해 자동으로 생성되도록함. 'IDENTITY' 전략은 보통 mysql에서 'AUTO_INCREMENT'를 사용하여 기본 키를 생성함
    private Long id;

    @Column(name ="e_mail", unique = true)
    private String e_mail;

    @Column(name ="password", unique = true)
    private String password;

    @Column(name ="nickname")
    private String nickname;

    @Column(name ="year")
    private String year;

    @Column(name ="month")
    private String month;

    @Column(name ="day")
    private String day;

    @Column(name ="gen")
    private int gen; //0이면 여자 1이면 남자

    public Member(Long id, String e_mail, String password, String nickname, String year, String month, String day, int gen) {
        this.id = id;
        this.e_mail = e_mail;
        this.password = password;
        this.nickname = nickname;
        this.year = year;
        this.month = month;
        this.day = day;
        this.gen = gen;
    }

    protected String getE_mail() {
        return e_mail;
    }
    protected String getPassword() {
        return password;
    }
}
