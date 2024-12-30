package com.prajwal.lms.entities.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prajwal.lms.entities.Member;

public interface MemberRepo extends JpaRepository<Member, Long> {

}
