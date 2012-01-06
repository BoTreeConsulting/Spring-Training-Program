package com.botreeconsulting.lms.hibernate.xml.model;

import java.util.HashSet;
import java.util.Set;

public class Author {

	private Long id;
	private String firstName;
	private String lastName;
	private Set<Book> books = new HashSet<Book>();
	
	public Author() {
		// TODO Auto-generated constructor stub
	}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	// TODO: Override and Implement toString()
}
