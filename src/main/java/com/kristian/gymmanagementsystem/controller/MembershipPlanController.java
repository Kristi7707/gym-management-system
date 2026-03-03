package com.kristian.gymmanagementsystem.controller;

import com.kristian.gymmanagementsystem.model.MembershipPlan;
import com.kristian.gymmanagementsystem.service.MembershipPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
public class MembershipPlanController {

    private final MembershipPlanService membershipPlanService;

    @GetMapping
    public List<MembershipPlan> getAllPlans(){
        return membershipPlanService.getAllPlans();
    }

    @PostMapping
    public MembershipPlan addPlan(@RequestBody MembershipPlan plan){
        return membershipPlanService.addPlan(plan);
    }

    @PutMapping("/{id}")
    public MembershipPlan updatePlan(@PathVariable Long id, @RequestBody MembershipPlan plan){
        return membershipPlanService.updatePlan(id, plan);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id){
        membershipPlanService.deletePlan(id);
    }
}