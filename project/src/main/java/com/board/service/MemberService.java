package com.board.service;

import com.board.entity.Member;
import com.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member Save(Member member)
    {
        return memberRepository.save(member);
    }
    public Member getEmail(Member member)
    {
        return memberRepository.findById(member.getId()).get();
    }
    public Member getPassword(Member member)
    {
        return memberRepository.(member.getId()).get();
    }
}
