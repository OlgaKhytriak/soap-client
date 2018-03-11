package com.epam.test;

import static com.epam.web.service.Status.*;
import static org.testng.Assert.*;
import java.util.List;

import com.epam.web.service.NewspaperResponse;
import com.epam.web.service.SingleNews;
import com.epam.web.service.impl.NewspaperService;
import com.epam.web.service.impl.NewspaperServiceImplService;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class NewspaperTest {
    private static final Logger LOG = Logger.getLogger(NewspaperTest.class);
	private static NewspaperService newspaperService = new NewspaperServiceImplService().getNewspaperServiceImplPort();
	

	@Test
	public void getAllTest(){
        LOG.info(String.format(" ---- %s. getAllTest() ----- ", this.getClass().getSimpleName()));
        NewspaperResponse response = newspaperService.getAllNews();
		List<Object> allNews = response.getResult();
		LOG.info("Is response null? - "+(allNews == null));

		String actualStatus = response.getStatus().getMessage();
		LOG.info(String.format("Actual result = %s",actualStatus));
		LOG.info(String.format("Expect result = %s",GET_ALL));
		assertEquals(actualStatus,GET_ALL);
	}
	@Test
	public void getNewsByIdTest(){
        LOG.info(String.format(" ---- %s. getNewsByIdTest() ----- ", this.getClass().getSimpleName()));

        NewspaperResponse response = newspaperService.getNewsById(1);
		SingleNews expectedNews=new SingleNews(1, "Gold-medal", "Sport", "Gold medalist Abramenko carries Ukrainian flag at Winter Olympics 2018 closing ceremony", "https://24tv.ua");
		SingleNews actualNews = (SingleNews) response.getResult().get(0);
		assertEquals(actualNews,expectedNews);

		String actualStatus = response.getStatus().getMessage();
		LOG.info(String.format("Actual result = %s",actualStatus));
		LOG.info(String.format("Expect result = %s",GET_BY_ID));
		assertEquals(actualStatus,GET_BY_ID);
	}

	@Test
	public void getNewsByIdNegativeTest(){
        LOG.info(String.format(" ---- %s. getNewsByIdNegativeTest() ----- ", this.getClass().getSimpleName()));

        NewspaperResponse response = newspaperService.getNewsById(-1);
		SingleNews actualNews = (SingleNews) response.getResult();

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,NO_SUCH_NEWS);
	}

	@Test
	public void getNewsByTitleTest(){
        LOG.info(String.format(" ---- %s. getNewsByTitleTest() ----- ", this.getClass().getSimpleName()));

        NewspaperResponse response = newspaperService.getNewsByTitle("Box");
		SingleNews expectedNews=new SingleNews(4, "Box", "Sport", "Ukrainian Artem Dalakian becomes new WBA flyweight champion", "https://zik.ua");
		SingleNews actualNews = (SingleNews) response.getResult().get(0);
		assertEquals(actualNews,expectedNews);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,GET_BY_TITLE);
	}

	@Test
	public void getNewsByTitleNegativeTest(){
        LOG.info(String.format(" ---- %s. getNewsByTitleNegativeTest() ----- ", this.getClass().getSimpleName()));

        NewspaperResponse response = newspaperService.getNewsByTitle("Som unknown title");
		SingleNews actualNews = (SingleNews) response.getResult();
		LOG.info("Is response null? - "+(actualNews == null));
		assertNull(actualNews);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,NO_SUCH_NEWS);
	}

	@Test
	public void addNewsTest(){
        LOG.info(String.format(" ---- %s. addNewsTest() ----- ", this.getClass().getSimpleName()));

        SingleNews newsToAdd=new SingleNews(457, "My news", "politics", "Ukrainian politics", "https://zik.ua");
		NewspaperResponse response = newspaperService.addNews(newsToAdd);
		SingleNews actual = (SingleNews) newspaperService.getNewsByTitle("My news").getResult().get(0);
		LOG.info("Is response null? - "+(actual == null));
		assertNotNull(actual);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,ALREADY_EXIST);

	}

	@Test
	public void addNewsNegativeTest(){
        LOG.info(String.format(" ---- %s. addNewsNegativeTest() ----- ", this.getClass().getSimpleName()));

        SingleNews newsToAdd=new SingleNews(4, "Box", "Sport", "Ukrainian Artem Dalakian becomes new WBA flyweight champion", "https://zik.ua");
		NewspaperResponse response = newspaperService.addNews(newsToAdd);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,ALREADY_EXIST);
	}

	@Test
	public void updateNewsTest(){
        LOG.info(String.format(" ---- %s. updateNewsTest() ----- ", this.getClass().getSimpleName()));

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
        LOG.info(String.format(" ---- %s. updateNewsNegativeTest() ----- ", this.getClass().getSimpleName()));

        SingleNews newsToAdd=new SingleNews(3,"My news", "politics", "Ukrainian politics", "https://zik.ua");
		SingleNews oldNews = new SingleNews(3,"Wrong news", "wrong", "Ukrainian politics", "https://zik.ua");
		NewspaperResponse response = newspaperService.updateNews(oldNews, newsToAdd);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,NO_SUCH_NEWS);
	}

	@Test
	public void removeNewsTest(){
        LOG.info(String.format(" ---- %s. removeNewsTest() ----- ", this.getClass().getSimpleName()));

        NewspaperResponse response = newspaperService.deleteNews(1);

		String actualStatus = response.getStatus().getMessage();
		assertEquals(actualStatus,DELETE);
	}
	
	
	


}
