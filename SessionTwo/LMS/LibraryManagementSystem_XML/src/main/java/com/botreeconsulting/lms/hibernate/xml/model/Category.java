package com.botreeconsulting.lms.hibernate.xml.model;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private Long id;
	private String categoryCode; // this should be unique
	private String categoryName;
	private Set<Book> books = new HashSet<Book>();
	
	public Category() {
	}
	
	public Category(String categoryCode, String categoryName) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
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
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}

	/**
	 * @param categoryCode
	 *            the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryCode == null) ? 0 : categoryCode.hashCode());
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
		Category other = (Category) obj;
		if (categoryCode == null) {
			if (other.categoryCode != null)
				return false;
		} else if (!categoryCode.equals(other.categoryCode))
			return false;
		return true;
	}

	// TODO: Override and Implement toString()

}
