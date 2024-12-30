package com.prajwal.lms.entities.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prajwal.lms.entities.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
	List<Book> findByTitle(String title);
}
