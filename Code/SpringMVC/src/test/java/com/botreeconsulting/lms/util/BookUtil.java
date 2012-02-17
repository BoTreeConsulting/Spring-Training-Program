package com.botreeconsulting.lms.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.model.Publisher;

public class BookUtil extends EntityUtil<Book, Long> {

	public BookUtil(Session session, Class<Book> entityClass) {
		super(session, entityClass);
	}
	
	public static final String TEST_TITLE = "Learning Rails";
	public static final int TEST_TITLE_EXPECTED_RESULTS_COUNT = 1;
	
	public static final String TEST_KEYWORD = "Learning";
	public static final int TEST_KEYWORD_EXPECTED_RESULTS_COUNT = 2;
	
	private static final String[][] TEST_BOOKS = {
		// Format -> { isbn, title, pages, totalCopies, copiesAvailable}
		{"II-123-BC", "Learning Rails", "250", "5", "5"},
		{"A1-463-CD", "Learning Ruby", "499", "5", "5"},
		{"PS-156-MG", "jQuery In Action", "652", "5", "5"},
		{"24-CBD-15", "Spring In Action", "350", "5", "5"},
		{"RS-F25-14", "Hibernate In Action", "495", "5", "5"}
	};

	
	private static final String ISBN_PROPERTY = "isbn";
	private static final String TITLE_PROPERTY = "title";
	
	
	/**
	 * 
	 * @param isbn the ISBN of the book to add the specified 
	 * <code>publisher</code> to
	 * 
	 * @param publisher the {@link Publisher} instance holding a publisher details
	 * 
	 * @return the updated {@link Book} instance having the specified 
	 * <code>publisher</code> associated to it, or NULL if the book could not be found
	 * by the system for the specified <code>isbn</code> to
	 */
	public Book updateBookByAddingPublisher(String isbn, Publisher publisher) {
		Book book = findBookByISBN(isbn);
		
		if (book != null) {
			book.setPublisher(publisher);
			
			updateEntity(book);
		}
		
		return book;
	}
	
	/**
	 * 
	 * @param isbn the ISBN of the book to add the specified 
	 * <code>authors</code> to
	 * 
	 * @param authors an array of {@link Author} instances
	 *  
	 * @return the updated {@link Book} instance having the specified 
	 * <code>authors</code> associated to it, or NULL if the book could not be found
	 * by the system for the specified <code>isbn</code> to
	 */
	public Book updateBookByAddingAuthors(String isbn, Author... authors) {
		Book book = findBookByISBN(isbn);
		
		if (book != null) {
			
			for (Author author : authors) {
				// Book and Author has a bidirectional association so links 
				// from both ends of association are to created.Thus using
				// this convenience method addAuthor
				book.addAuthor(author); 
			}
			
			// Here saveOrUpdate is used instead of updateEntity which merges 
			// the state of persistence instance.In this case transient instances
			// of Author are in picture.Thus save or update is to be used.
			getSession().saveOrUpdate(book);
			
		}
		
		return book;
	}
	
	
	/**
	 * 
	 * @param isbn the ISBN
	 * 
	 * @return the persistent {@link Book} instance having the specified 
	 * <code>isbn</code> or NULL if the book could not found in the system
	 * having the specified <code>isbn</code> or the specified 
	 * <code>isbn</code> is found null/empty
	 */
	public Book findBookByISBN(String isbn) {
		Criteria criteria = getCriteriaForEntity();
		
		if (StringUtil.isNotEmpty(isbn)) {
			criteria.add(Restrictions.eq(ISBN_PROPERTY, isbn));
			return (Book) criteria.uniqueResult();
		} 
		
		return null;
	}
	
	/**
	 * 
	 * @param title the title
	 * @param matchExactTitle a boolean <code>true</code> to indicate match the 
	 * exact title and <code>false</code> to match the title anywhere in the 
	 * available books title. 
	 * 
	 * @return a {@link List} of the persistent {@link Book} instances having
	 *  the specified <code>title</code> or an empty list if the books
	 *  with specified <code>title</code> are not available in the system
	 *  or the specified <code>title</code> is found null/empty
	 */
	@SuppressWarnings("unchecked")
	public List<Book> findBooksByTitle(String title, boolean matchExactTitle) {
		Criteria criteria = getCriteriaForEntity();
		
		if (StringUtil.isNotEmpty(title)) {
			
			if (matchExactTitle) {
				criteria.add(Restrictions.eq(TITLE_PROPERTY, title));	
			} else {
				criteria.add(Restrictions.ilike(TITLE_PROPERTY, title, MatchMode.ANYWHERE));
			}
			
			return criteria.list();
		} 
		
		return Collections.emptyList();
	}
	
	/**
	 * 
	 * @return
	 */
	public static final List<Book> getTestBooks() {
		List<Book> testBooks = new ArrayList<Book>(TEST_BOOKS.length);
		
		for (String[] testBook : TEST_BOOKS) {
			testBooks.add(getTestBook(
								testBook[0], testBook[1],
								Integer.parseInt(testBook[2]), 
								Integer.parseInt(testBook[3]), 
								Integer.parseInt(testBook[4])));
		}
		return testBooks;
	}
	
	private static Book getTestBook(
			String isbn, String title, int pages, int totalCopies, int copiesAvailable) {
		
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setPages(pages);
		book.setTotalCopies(totalCopies);
		book.setCopiesAvailable(copiesAvailable);
		return book;
	}
}
