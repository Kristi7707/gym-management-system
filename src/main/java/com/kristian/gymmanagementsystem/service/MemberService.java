package com.kristian.gymmanagementsystem.service;

import com.kristian.gymmanagementsystem.model.Member;
import com.kristian.gymmanagementsystem.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public Member addMember(Member member){
        return memberRepository.save(member);
    }
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElseThrow();
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }
}
