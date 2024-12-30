package com.prajwal.lms.services;

import com.prajwal.lms.entities.Borrowing;

public interface BorrowingService {
	Borrowing borrowBook(long borrowId, long memberId);

	Borrowing returnBook(long borrowId);
}
