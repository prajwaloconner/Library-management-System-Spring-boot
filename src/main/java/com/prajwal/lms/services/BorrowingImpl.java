package com.prajwal.lms.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prajwal.lms.entities.Book;
import com.prajwal.lms.entities.Borrowing;
import com.prajwal.lms.entities.Member;
import com.prajwal.lms.entities.repos.BookRepo;
import com.prajwal.lms.entities.repos.BorrowingRepo;
import com.prajwal.lms.entities.repos.MemberRepo;

@Service
public class BorrowingImpl implements BorrowingService {
	@Autowired
	BookRepo b;
	@Autowired
	BorrowingRepo br;
	@Autowired
	MemberRepo m;

	@Override
	public Borrowing borrowBook(long bookId, long memberId) {
		Book book = b.findById(bookId).get();
		Member byId = m.findById(memberId).get();
		Borrowing b1 = new Borrowing();
		b1.setBook(book);
		b1.setBorrowedDate(new Date());
		b1.setMember(byId);
		return br.save(b1);
	}

	@Override
	public Borrowing returnBook(long borrowId) {
		Borrowing borrowing = br.findById(borrowId).get();
		borrowing.setReturnDate(new Date());
		return br.save(borrowing);
	}

}
