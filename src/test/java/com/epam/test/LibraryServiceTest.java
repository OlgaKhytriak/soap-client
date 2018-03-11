package com.epam.test;

import static org.testng.Assert.*;
import java.util.List;

import com.epam.web.service.NewspaperResponse;
import com.epam.web.service.impl.NewspaperService;
import com.epam.web.service.impl.NewspaperServiceImplService;
import org.testng.annotations.Test;



public class LibraryServiceTest {
	
	private static NewspaperService SERVICE = new NewspaperServiceImplService().getNewspaperServiceImplPort();
	
	@Test
	public void getAllNewsTest(){
		NewspaperResponse response = SERVICE.getAllNews();
		List<Object> allBooks = response.getResult();
		assertNotNull(allBooks);
		assertEquals(allBooks.size(),10);
		
		String expectedStatus = "All news was got successfully";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
		
	}
	
/*
	@Test
	public void getBookByIdSuccesTest(){
		LibraryWSResponse response = SERVICE.getBookById(1);
		Book expected = new Book("The Sacred Sword", "Scott Mariani", "Action & Adventure",1);
		Book actual = (Book) response.getResult().get(0);
		
		assertNotNull(actual);
		assertEquals(actual,expected);
		
		String expectedStatus = "Get book by id successfully";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
	}
	
	@Test
	public void getBookByIdFailureTest(){
		LibraryWSResponse response = SERVICE.getBookById(-1);
		Book actual = (Book) response.getResult();
		
		assertNull(actual);
		
		String expectedStatus = "There is no such book";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
	}
	
	@Test
	public void getBookByNameSuccesTest(){
		LibraryWSResponse response = SERVICE.getBookByName("Crystal Magic");
		Book expected = new Book("Crystal Magic", "Madeline Freeman", "Fantasy",7);
		Book actual = (Book) response.getResult().get(0);
		
		assertNotNull(actual);
		assertEquals(actual,expected);
		
		String expectedStatus = "Get book by name successfully";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
	}
	
	@Test
	public void getBookByNameFailureTest(){
		LibraryWSResponse response = SERVICE.getBookByName("___________________");
		Book actual = (Book) response.getResult();
		
		assertNull(actual);
		
		String expectedStatus = "There is no such book";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
	}
	
	@Test
	public void giveBackBookSuccesTest(){
		Book giveBackBook = new Book("Give Back Book Name", "Give Back Book Author", "Fantasy",101);
		LibraryWSResponse response = SERVICE.giveBackBook(giveBackBook);
		
		Book actual = (Book) SERVICE.getBookByName("Give Back Book Name").getResult().get(0);
		
		assertNotNull(actual);
				
		String expectedStatus = "Book added to the library successfully";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
		
		SERVICE.deleteBook(101);
	}
	
	@Test
	public void giveBackBookFailureTest(){
		Book giveBackBook = new Book("And Then There Were None", "Agatha Christie", "Thriller",3);
		LibraryWSResponse response = SERVICE.giveBackBook(giveBackBook);
				
		String expectedStatus = "This book exists already.";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
	}
	
	@Test
	public void changeBookSuccessTest(){
		Book newBook = new Book("New Book", "H.G. Wells", "Fantasy",8);
		Book oldBook = (Book) SERVICE.getBookById(8).getResult().get(0);
		
		LibraryWSResponse response = SERVICE.changeBook(oldBook, newBook);
				
		Book expectedBook = newBook;
		Book actualBook = (Book) SERVICE.getBookByName("New Book").getResult().get(0);
		
		assertEquals(actualBook,expectedBook);
		
		String expectedStatus = "Book changed successfully";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
	}
	
	@Test
	public void changeBookNoSuchBookFailureTest(){
		Book newBook = new Book("New Book", "H.G. Wells", "Fantasy",10110);
		Book oldBook = new Book("Some Old Book _______", "H.G. Wells", "Fantasy",123123);
		LibraryWSResponse response = SERVICE.changeBook(oldBook, newBook);
				
		String expectedStatus = "There is no such book";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
	}
	@Test
	public void changeBookInCorrectBookFailureTest(){
		Book newBook = new Book("", "", "",10110);
		Book oldBook = (Book) SERVICE.getBookById(2).getResult().get(0);
		LibraryWSResponse response = SERVICE.changeBook(oldBook, newBook);
				
		String expectedStatus = "There is no correct arguments";
		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,expectedStatus);
	}
	
	
	
	*/

}
