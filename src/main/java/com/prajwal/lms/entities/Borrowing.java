package com.prajwal.lms.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Borrowing {
	@Id
	private long id;
	@ManyToOne
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	private Book book;
	@ManyToOne
	@JoinColumn(name = "member_id", referencedColumnName = "id")
	private Member member;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	@Override
	public String toString() {
		return "Borrowing [id=" + id + ", book=" + book + ", member=" + member + ", borrowedDate=" + borrowedDate + "]";
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	private Date borrowedDate;
	private Date returnDate;
}
