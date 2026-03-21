package com.kristian.gymmanagementsystem.controller;

import com.kristian.gymmanagementsystem.model.Member;
import com.kristian.gymmanagementsystem.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;



    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public Member addMember(@Valid @RequestBody Member member){
        return memberService.addMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member){
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }

    @PutMapping("/{memberId}/assign-trainer/{trainerId}")
    public Member assignTrainer(@PathVariable Long memberId, @PathVariable Long trainerId){
        return memberService.assignTrainer(memberId, trainerId);
    }

    @PutMapping("/{memberId}/unassign-trainer")
    public Member unassignTrainer(@PathVariable Long memberId){
        return memberService.unassignTrainer(memberId);
    }
}
