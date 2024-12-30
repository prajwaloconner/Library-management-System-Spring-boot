package com.prajwal.lms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prajwal.lms.entities.Borrowing;
import com.prajwal.lms.entities.repos.BookRepo;
import com.prajwal.lms.entities.repos.BorrowingRepo;
import com.prajwal.lms.entities.repos.MemberRepo;
import com.prajwal.lms.services.BorrowingService;

@Controller
public class BorrowController {
	@Autowired
	BorrowingRepo br;
	@Autowired
	BookRepo b;
	@Autowired
	MemberRepo m;
	@Autowired
	BorrowingService bs;

	@GetMapping("/borrow")
	public ModelAndView borrowbooks() {
		ModelAndView m1 = new ModelAndView("borrow_book");
		m1.addObject("books", b.findAll());
		m1.addObject("members", m.findAll());
		return m1;
	}

	@PostMapping("/borrow")
	public ModelAndView borrowCreate(@RequestParam Long bookId, @RequestParam Long memberId) {
		ModelAndView m1 = new ModelAndView("borrow_success");
		Borrowing book = bs.borrowBook(bookId, memberId);
		br.save(book);
		m1.addObject("message", "borrowed the book succesfully");
		return m1;
	}

	@GetMapping("/return")
	public ModelAndView returnbooks() {
		List<Borrowing> all = br.findAll();
		ModelAndView m1 = new ModelAndView("return_book");
		m1.addObject("borrowers", all);
		return m1;
	}

	@PostMapping("/return")
	public ModelAndView giveback(@RequestParam(required = false) Long borrowingId) {
		Borrowing book = bs.returnBook(borrowingId);
		ModelAndView m2 = new ModelAndView("return_success");
		br.save(book);
		m2.addObject("message", "The book returned succesfully");
		return m2;
	}

}
