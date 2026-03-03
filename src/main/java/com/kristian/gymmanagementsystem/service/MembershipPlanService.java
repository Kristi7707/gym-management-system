package com.kristian.gymmanagementsystem.service;

import com.kristian.gymmanagementsystem.model.MembershipPlan;
import com.kristian.gymmanagementsystem.repository.MembershipPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipPlanService {

    private final MembershipPlanRepository membershipPlanRepository;

    public MembershipPlan addPlan(MembershipPlan plan){
        return membershipPlanRepository.save(plan);
    }

    public List<MembershipPlan> getAllPlans(){
        return membershipPlanRepository.findAll();
    }

    public MembershipPlan getPlanById(Long id){
        return membershipPlanRepository.findById(id).orElseThrow();
    }

    public MembershipPlan updatePlan(Long id, MembershipPlan updatedPlan){
        MembershipPlan exsiting = membershipPlanRepository.findById(id).orElseThrow();
        exsiting.setName(updatedPlan.getName());
        exsiting.setPrice(updatedPlan.getPrice());
        exsiting.setDurationDays(updatedPlan.getDurationDays());
        exsiting.setDescription(updatedPlan.getDescription());
        return membershipPlanRepository.save(exsiting);
    }
    public void deletePlan(Long id){
        membershipPlanRepository.deleteById(id);
    }
}