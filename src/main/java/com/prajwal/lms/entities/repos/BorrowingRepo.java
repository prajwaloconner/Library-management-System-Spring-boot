package com.prajwal.lms.entities.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prajwal.lms.entities.Borrowing;

public interface BorrowingRepo extends JpaRepository<Borrowing, Long> {

}
