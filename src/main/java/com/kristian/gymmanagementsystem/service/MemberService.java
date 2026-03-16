package com.kristian.gymmanagementsystem.service;

import com.kristian.gymmanagementsystem.model.Member;
import com.kristian.gymmanagementsystem.model.Trainer;
import com.kristian.gymmanagementsystem.repository.MemberRepository;
import com.kristian.gymmanagementsystem.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TrainerRepository trainerRepository;
    public Member assignTrainer(Long memberId, Long trainerId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        member.setTrainer(trainer);
        return memberRepository.save(member);
    }

    public Member unassignTrainer(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        member.setTrainer(null);
        return memberRepository.save(member);
    }
    public Member addMember(Member member){
        return memberRepository.save(member);
    }
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElseThrow();
    }

    public Member updateMember(Long id, Member updatedMember){
        Member existing = memberRepository.findById(id).orElseThrow();
        existing.setName(updatedMember.getName());
        existing.setEmail(updatedMember.getEmail());
        existing.setPhone(updatedMember.getPhone());
        existing.setMembershipType(updatedMember.getMembershipType());
        existing.setActive(updatedMember.isActive());
        return memberRepository.save(existing);
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }
}
