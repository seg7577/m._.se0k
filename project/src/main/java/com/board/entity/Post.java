package com.board.entity;
//이 Entity는 데이터베이스의 Post테이블과 매핑됨

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
@Table(name = "post")
public class Post {
    @Id//이 필드가 엔티티의 기본 키임을 나타냄

    @GeneratedValue(strategy = GenerationType.IDENTITY)//기본 키가 데이터베이스에 의해 자동으로 생성되도록함. 'IDENTITY' 전략은 보통 mysql에서 'AUTO_INCREMENT'를 사용하여 기본 키를 생성함
    private Long id;//id필드는 post 엔티티의 기본 키로 사용됨
    private String title;//title 필드는 게시물의 제목
    private String author;//author 필드는 게시물의 작성자를 나타냄
    private LocalDateTime createdDate;//createDate 필드는 게시물이 생성된 날짜와 시간을 나타내며, 기본값은 현재 시간으로 설정됨
    private LocalDateTime modifiedDate;//modifiedDate 필드는 게시물이 수정된 날짜와 시간을 나타냄

    //콜백 메서드
    @PrePersist//엔티티가 처음으로 저장되기 전에 호출됨 'onCreate'메서드는 'createDate'를 현재 시간으로 설정함
    protected void onCreate(){
        createdDate = LocalDateTime.now();
    }

    @PreUpdate//엔티티가 업데이트 되기 전에 호출됨. 'onUpdate' 메서드는 'modifiedDate'를 현재 시간으로 설정함
    protected void onUpdate(){
        modifiedDate = LocalDateTime.now();
    }
}
