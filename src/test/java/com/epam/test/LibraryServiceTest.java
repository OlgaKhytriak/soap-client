package com.epam.test;

import static com.epam.web.service.Status.*;
import static org.testng.Assert.*;
import java.util.List;

import com.epam.web.service.NewspaperResponse;
import com.epam.web.service.SingleNews;
import com.epam.web.service.impl.NewspaperService;
import com.epam.web.service.impl.NewspaperServiceImplService;
import org.testng.annotations.Test;

public class LibraryServiceTest {
	
	private static NewspaperService newspaperService = new NewspaperServiceImplService().getNewspaperServiceImplPort();
	

	@Test
	public void getAllTest(){
		NewspaperResponse response = newspaperService.getAllNews();
		List<Object> allNews = response.getResult();
		//assertEquals(allNews.size(),10);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,GET_ALL);
	}
	@Test
	public void getNewsByIdTest(){
		NewspaperResponse response = newspaperService.getNewsById(1);
		SingleNews expectedNews=new SingleNews(1, "Gold-medal", "Sport", "Gold medalist Abramenko carries Ukrainian flag at Winter Olympics 2018 closing ceremony", "https://24tv.ua");
		SingleNews actualNews = (SingleNews) response.getResult().get(0);
		assertEquals(actualNews,expectedNews);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,GET_BY_ID);
	}

	@Test
	public void getNewsByIdNegativeTest(){
		NewspaperResponse response = newspaperService.getNewsById(-1);
		SingleNews actualNews = (SingleNews) response.getResult();

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,NO_SUCH_NEWS);
	}

	@Test
	public void getNewsByTitleTest(){
		NewspaperResponse response = newspaperService.getNewsByTitle("Box");
		SingleNews expectedNews=new SingleNews(4, "Box", "Sport", "Ukrainian Artem Dalakian becomes new WBA flyweight champion", "https://zik.ua");
		SingleNews actualNews = (SingleNews) response.getResult().get(0);
		assertEquals(actualNews,expectedNews);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,GET_BY_TITLE);
	}

	@Test
	public void getNewsByTitleNegativeTest(){
		NewspaperResponse response = newspaperService.getNewsByTitle("Som unknown title");
		SingleNews actualNews = (SingleNews) response.getResult();
		assertNull(actualNews);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,NO_SUCH_NEWS);
	}

	@Test
	public void addNewsTest(){
		SingleNews newsToAdd=new SingleNews(457, "My news", "politics", "Ukrainian politics", "https://zik.ua");
		NewspaperResponse response = newspaperService.addNews(newsToAdd);
		SingleNews actual = (SingleNews) newspaperService.getNewsByTitle("My news").getResult().get(0);
		assertNotNull(actual);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,ALREADY_EXIST);

	}

	@Test
	public void addNewsNegativeTest(){
		SingleNews newsToAdd=new SingleNews(4, "Box", "Sport", "Ukrainian Artem Dalakian becomes new WBA flyweight champion", "https://zik.ua");
		NewspaperResponse response = newspaperService.addNews(newsToAdd);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,ALREADY_EXIST);
	}

	@Test
	public void updateNewsTest(){
		SingleNews newsToAdd=new SingleNews(3,"My news", "politics", "Ukrainian politics", "https://zik.ua");
		SingleNews oldNews = (SingleNews) newspaperService.getNewsById(3).getResult().get(0);
		NewspaperResponse response = newspaperService.updateNews(oldNews, newsToAdd);

		SingleNews expectedNews = newsToAdd;
		SingleNews actualNews = (SingleNews) newspaperService.getNewsByTitle("My news").getResult().get(0);
		assertEquals(actualNews,expectedNews);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,UPDATE);
	}

	@Test
	public void updateNewsNegativeTest(){
		SingleNews newsToAdd=new SingleNews(3,"My news", "politics", "Ukrainian politics", "https://zik.ua");
		SingleNews oldNews = new SingleNews(3,"Wrong news", "wrong", "Ukrainian politics", "https://zik.ua");
		NewspaperResponse response = newspaperService.updateNews(oldNews, newsToAdd);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,NO_SUCH_NEWS);
	}

	@Test
	public void removeNewsTest(){
		NewspaperResponse response = newspaperService.deleteNews(1);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,DELETE);
	}
	
	
	


}
