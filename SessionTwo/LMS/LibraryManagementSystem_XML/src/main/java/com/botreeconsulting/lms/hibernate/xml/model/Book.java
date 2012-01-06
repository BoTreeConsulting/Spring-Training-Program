package com.botreeconsulting.lms.hibernate.xml.model;

import java.util.HashSet;
import java.util.Set;

public class Book {

	private Long id;
	private String isbn; // this should be unique
	private String title;
	private int pages;
	private int totalCopies;
	private int copiesAvailable;
	private AvailabilityStatus availabilityStatus = AvailabilityStatus.AVAILABLE; // Default
	private Publisher publisher;
	private Set<Author> authors = new HashSet<Author>();
	private Set<Category> categories = new HashSet<Category>();
	

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
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages
	 *            the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	

	/**
	 * @return the availabilityStatus
	 */
	public AvailabilityStatus getAvailabilityStatus() {
		return availabilityStatus;
	}

	/**
	 * @param availabilityStatus
	 *            the availabilityStatus to set
	 */
	public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	/**
	 * @return the totalCopies
	 */
	public int getTotalCopies() {
		return totalCopies;
	}

	/**
	 * @param totalCopies
	 *            the totalCopies to set
	 */
	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	/**
	 * @return the copiesAvailable
	 */
	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	/**
	 * @param copiesAvailable
	 *            the copiesAvailable to set
	 */
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	
	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the authors
	 */
	public Set<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	/**
	 * Since the association is is bidirectional, you have to create the link on two
	 * sides, not just one.
	 * 
	 * A convenience method as implementing a managed association in the object model.
	 * between {@link Book} and {@link Author}
	 * 
	 * @param author
	 */
	public void addAuthor(Author author) {
		author.getBooks().add(this);
		authors.add(author);
	}


	/**
	 * @return the categories
	 */
	public Set<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	
	

	// TODO: Override and Implement toString()
}
