package com.board.service;

import com.board.entity.Member;
import com.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public Member Save(Member member)
    {
        if (!member.getPassword().equals(member.getPasswordCheck()))
        {
            throw new IllegalArgumentException("Password do not match");
            // 'IllegalArgumentException'은 java에서 발생하는 일반적인 예외 중 하나로, 메서드가 적절하지 않은 인수를 전달 받았을 때 발생한다.
            // 이 예외는 주로 잘못된 매개변수가 메서드에 전달되었을 떄, 이 호출하는 쪽에 즉각적으로 알려주기 위해 사용된다.

            /*  1. IllegalArgumentException 객체가 생성 되고, 메시지로 "Password .." 가 전달된다. 이 예외 객체는 즉시 메서드를 종료시키고, 예외를 던진다.
                2. 현재 메서드 종료한다. 즉 .save 함수가 실행 되지 않는다.
                3. 콜 스택 탐색 : JVM은 call stack을 탐색하여 예외를 처리할 수 있는 적절한 예외 처리기(try-catch)를 찾는다. 예외를 처리할 수 있는 블록을 찾을 때까지 콜 스택을 거슬러 올라온다.
                4. 예외 처리 : 'try-catch' 블록이 있다면, 그 블록에서 예외를 처리하고 그렇지 않은 경우, 예외는 게속해서 전파되며, JVM에 의해 잡히고 프로그램이 종료될 수 있다.
                5. 에러 메시지 출력 : 예외가 잡히면, 메시지가 출력되거나 로깅된다. 이 메시지는 문제의 원인을 쉽게 파악할 수 있도록 도와준다.
            */
        }

        return memberRepository.save(member);
    }
    public Optional<Member> getMemberByemail(String email)
    {
        return memberRepository.findByemail(email);
    }
    public Optional<Member> getmemberBypassword(String password)
    {
        return memberRepository.findBypassword(password);
    }

    public boolean login(Member member) {
        if (member.getEmail().equals(memberRepository.findById(member.getId())) && member.getPassword().equals(passwordEncoder.encode(member.getPassword())))
            return true;
        return false;
    }

//    public Member getPassword(Member member)
//    {
//        return memberRepository.find;
//    }
}
