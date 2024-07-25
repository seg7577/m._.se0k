package com.board.entity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor


//@Bean -> 이 메서드가 반환하는 객체를 Spring 컨테이너에 빈으로 등록한다.
public class SecurityConfig {

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        // 비밀번호를 함호화 하는 객체를 생성(bCryptPasswordEncoder) 후 반환함.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 특징 요청을 Spring Security 필터에서 제외하도록 설정함.
        return (web) -> web.ignoring()
                .requestMatchers("/css/**", "/js/**", "/images/**");
        // 정적 리소스 (css, js, 이미지 파일)등을 보안 필터링에서 제외함.
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // SecurityFilterChain: http 보안 필터 체인을 정의함.
        http
                .csrf(csrf->csrf.disable())
                //csrf 보호를 비활성화함. -> 로컬에서 확인을 위함
                .authorizeHttpRequests(requests -> requests
                        //요청에 대한 인증 및 권한 부여를 설정

                        .requestMatchers("/", "/post/login", "/post/account").permitAll()
                        //지정된 경로는 인증("/", "/post/login, /post/account") 없이 접근할 수 있도록 허용함. -> "/" 홈, "/post/login" 로그인 페이지, "/post/account" 회원가입 페이지는 로그인 없이 접근할 수 있도록 구성함.

                        .anyRequest().authenticated()
                        //그 외의 모든 요청은 인증을 요구한다.
                )
                .formLogin(form -> form
                        //폼 기반 로그인 설정을 정의함. -> /login 페이지를 커스터마이징 하여 로그인 체크를 할 때 해당 url을 타도록 셋팅하고 로그인 성공시 "/"로 페이지 이동하도록 함

                        .loginPage("/post/login")
                        //사용자 정의 로그인 페이지의 경로를 설정함.

                        .defaultSuccessUrl("/post/sucess", true)
                        //로그인 성공 후 이동할 기본 경로("/post/sucess")를 설정

                        .permitAll()
                        //로그인 페이지와 관련된 모든 요청을 허용함.

                )
                .logout(logout -> logout
                        //로그아웃 설정을 정의함.

                        .permitAll());
                        //로그아웃과 관련된 모든 요청을 허용함

        return http.build();
        //설정된 보안 필터 체인을 반환함.
    }
}


