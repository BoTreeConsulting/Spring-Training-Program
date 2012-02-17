package com.botreeconsulting.lms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String isbn; // this should be unique
	
	@Column(nullable=false)
	private String title;
	
	@Column
	private int pages;
	
	@Column(nullable=false)
	private int totalCopies;
	
	@Column(nullable=false)
	private int copiesAvailable;
	
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private AvailabilityStatus availabilityStatus = AvailabilityStatus.AVAILABLE; // Default
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="publisherId")
	private Publisher publisher;
	
	@ManyToMany
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	// It is recommended by Hibernate Documentation over @*To*(cascade=)
	// Ref : http://docs.jboss.org/hibernate/stable/annotations/reference/en/html/entity.html#entity-hibspec-cascade
	@JoinTable(
		      name="BookAuthor",
		      joinColumns={@JoinColumn(name="bookId", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="authorId", referencedColumnName="id")}
		      )
	private Set<Author> authors = new HashSet<Author>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		      name="BookCategory",
		      joinColumns={@JoinColumn(name="bookId", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="categoryId", referencedColumnName="id")}
		      )
	private Set<Category> categories = new HashSet<Category>();
	

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		      name="BookUser",
		      joinColumns={@JoinColumn(name="bookId", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="userId", referencedColumnName="id")}
		      )
	private Set<User> users = new HashSet<User>();
	
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

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title
				+ "]";// +
				//", authors=" + authors + "]";
	}	
}
