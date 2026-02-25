package com.kristian.gymmanagementsystem.repository;

import com.kristian.gymmanagementsystem.model.Member;
import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface MemberRepository extends JpaRepository<Member, Long>{
}
