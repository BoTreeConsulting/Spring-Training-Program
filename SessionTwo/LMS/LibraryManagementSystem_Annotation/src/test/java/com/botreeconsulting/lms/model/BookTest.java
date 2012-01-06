package com.botreeconsulting.lms.model;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.botreeconsulting.lms.util.AuthorUtil;
import com.botreeconsulting.lms.util.BookUtil;
import com.botreeconsulting.lms.util.PublisherUtil;

public class BookTest extends GenericTestBase<Book, Long> {

	private List<Book> testBooks = null;
	private BookUtil bookUtil = null;
	
	
	@Before
	public void addBooks() {
		Session session = openSession();
		
		// Create BookUtil
		bookUtil = new BookUtil(session, Book.class);
		
		// Set EntityUtil to BookUtil
		setEntityUtil(bookUtil);
		
		// Get test books
		testBooks = BookUtil.getTestBooks();
		
		// add test books
		addTestEntities(testBooks);
	}
	
	@After
	public void deleteAllUsers() {
		deleteAllEntities();
		
		bookUtil.getSession().close();
	}
	
	public void testAddBook() {
		printTestName("testAddBook");
		for (Book book : testBooks) {
			assertNotNull("Persisted User Id must not be null", book.getId());
		}
	}
	
	public void testFindBookByISBN() {
		printTestName("testFindBookByISBN");
		Book persistedBook = testBooks.get(2); 
		String isbn = persistedBook.getIsbn();
		Book book = bookUtil.findBookByISBN(isbn);
		assertNotNull("Book instance found for provided ISBN must not be null", book);
		assertEquals("Book instance found must have the same title as the persistent book name ", 
				persistedBook.getTitle(), book.getTitle());
	}
	
	public void testFindBooksByTitle() {
		printTestName("testFindBooksByTitle");
		List<Book> books = bookUtil.findBooksByTitle(BookUtil.TEST_TITLE, true);
		assertEquals("Count for the Books found by title must match with " +
				"test books saved having the title provided to search by", 
				BookUtil.TEST_TITLE_EXPECTED_RESULTS_COUNT, books.size());
	}
	
	public void testFindBooksByKeyword() {
		printTestName("testFindBooksByKeyword");
		List<Book> books = bookUtil.findBooksByTitle(BookUtil.TEST_KEYWORD, false);
		assertEquals("Count for the Books found by keyword must match with " +
				"test books saved having the keyword - in their title - provided" +
				"to search by", BookUtil.TEST_KEYWORD_EXPECTED_RESULTS_COUNT, 
				books.size());
	}

	@Test
	public void updateBookByAddingPublisher() {
		printTestName("updateBookByAddingPublisher");
		Publisher publisher = PublisherUtil.getTestPublishers().get(2);
		
		String isbn = testBooks.get(0).getIsbn();
		Book updatedBook = bookUtil.updateBookByAddingPublisher(isbn, publisher);
		assertNotNull("Updated Book instance with publisher must not be null", updatedBook);
		
		Publisher updatedBookPublisher = updatedBook.getPublisher();
		
		assertNotNull("Updated Book instance's publisher property must not be null", updatedBookPublisher);
		
		assertEquals("Updated Book's Publisher name must match with the " +
				"Publisher provided to update book with", publisher.getName(), 
				updatedBookPublisher.getName());
	}
	
	@Test
	public void updateBookByAddingAuthors() {
		printTestName("updateBookByAddingAuthors");
		
		String isbn = testBooks.get(0).getIsbn();
		List<Author> testAuthors = AuthorUtil.getTestAuthors();
		
		Author testAuthor1 = testAuthors.get(0);
		Author testAuthor2 = testAuthors.get(2);
		
		Book updatedBook = bookUtil.updateBookByAddingAuthors(isbn, testAuthor1, testAuthor2);
		
		assertNotNull("Updated Book instance with authors must not be null", updatedBook);
		
		Set<Author> updatedBookAuthors = updatedBook.getAuthors();
		
		assertNotNull("Updated Book instance's authors property must not be null and empty", 
					  updatedBookAuthors);
		
		assertEquals("Updated Book's[ISBN:" + isbn  + "] authors count must match with the " +
				"Authors provided to update book with", 2, updatedBookAuthors.size());
		
		
		String anotherISBN = testBooks.get(3).getIsbn();
		Book anotherUpdatedBook = bookUtil.updateBookByAddingAuthors(anotherISBN, testAuthor2);
		Set<Author> anotherUpdatedBookAuthors = anotherUpdatedBook.getAuthors();
		
		assertEquals("Updated Book's[ISBN:" + isbn  + "] authors count must match with the " +
				"Authors provided to update book with", 1, anotherUpdatedBookAuthors.size());
		
		// testAuthorForBook2 must now contain in all 2 books
		assertEquals(2, testAuthor2.getBooks().size());
				
		// Not doing this would throw error like:
		// deleted object would be re-saved by cascade (remove deleted object from associations)
		// when deleting books.The reason being the books are in the object graph of author(s).
		// Reference: https://forum.hibernate.org/viewtopic.php?p=2350533
		testAuthor1.getBooks().clear();
		testAuthor2.getBooks().clear();
	}
	
}
