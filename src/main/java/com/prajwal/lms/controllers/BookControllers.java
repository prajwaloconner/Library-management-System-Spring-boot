package com.prajwal.lms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prajwal.lms.entities.Book;
import com.prajwal.lms.entities.repos.BookRepo;
import com.prajwal.lms.entities.repos.MemberRepo;

@Controller
public class BookControllers {
	@Autowired
	BookRepo b;

	@GetMapping("/")
	public ModelAndView books() {
		ModelAndView m = new ModelAndView("books");
		List<Book> books = b.findAll();
		m.addObject("books", books);
		return m;
	}

	@GetMapping("/book/new")
	public ModelAndView createbook() {
		ModelAndView m = new ModelAndView("create_book");
		Book book = new Book();
		m.addObject("book", book);
		return m;
	}

	@PostMapping("/books")
	public ModelAndView insert(Book book) {
		ModelAndView m = new ModelAndView("redirect:/");
		b.save(book);
		return m;

	}

	@GetMapping("/delete")
	public ModelAndView deletebook() {
		ModelAndView m = new ModelAndView("delete_book");
		List<Book> list = b.findAll();
		m.addObject("books", list);
		return m;
	}

	@PostMapping("/delete")
	public ModelAndView deletes(@RequestParam(required = false) String title) {
		List<Book> list = b.findByTitle(title);
		ModelAndView m = new ModelAndView("redirect:/");
		for (Book book : list) {
			b.delete(book);
		}
		return m;
	}

}
