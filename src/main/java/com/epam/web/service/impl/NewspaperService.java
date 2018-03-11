
package com.epam.web.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

import com.epam.web.service.NewspaperResponse;
import com.epam.web.service.ObjectFactory;
import com.epam.web.service.SingleNews;


@WebService(name = "NewspaperService", targetNamespace = "http://service.web/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
        ObjectFactory.class
})
public interface NewspaperService {


    /**
     * @param newsCategory
     * @return returns web.service.NewspaperResponse
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://service.web/NewspaperService/getNewsByCategoryRequest", output = "http://service.web/NewspaperService/getNewsByCategoryResponse")
    public NewspaperResponse getNewsByCategory(
            @WebParam(name = "news-category", partName = "news-category")
                    String newsCategory);

    /**
     * @param newsTitle
     * @return returns web.service.NewspaperResponse
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://service.web/NewspaperService/getNewsByTitleRequest", output = "http://service.web/NewspaperService/getNewsByTitleResponse")
    public NewspaperResponse getNewsByTitle(
            @WebParam(name = "news-title", partName = "news-title")
                    String newsTitle);

    /**
     * @param newsId
     * @return returns web.service.NewspaperResponse
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://service.web/NewspaperService/getNewsByIdRequest", output = "http://service.web/NewspaperService/getNewsByIdResponse")
    public NewspaperResponse getNewsById(
            @WebParam(name = "news-id", partName = "news-id")
                    int newsId);

    /**
     * @param oldNews
     * @param newNews
     * @return returns web.service.NewspaperResponse
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://service.web/NewspaperService/updateNewsRequest", output = "http://service.web/NewspaperService/updateNewsResponse")
    public NewspaperResponse updateNews(
            @WebParam(name = "old-news", partName = "old-news")
                    SingleNews oldNews,
            @WebParam(name = "new-news", partName = "new-news")
                    SingleNews newNews);

    /**
     * @param newsId
     * @return returns web.service.NewspaperResponse
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://service.web/NewspaperService/deleteNewsRequest", output = "http://service.web/NewspaperService/deleteNewsResponse")
    public NewspaperResponse deleteNews(
            @WebParam(name = "news-id", partName = "news-id")
                    int newsId);

    /**
     * @return returns web.service.NewspaperResponse
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://service.web/NewspaperService/getAllNewsRequest", output = "http://service.web/NewspaperService/getAllNewsResponse")
    public NewspaperResponse getAllNews();

    /**
     * @param newsToAdd
     * @return returns web.service.NewspaperResponse
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://service.web/NewspaperService/addNewsRequest", output = "http://service.web/NewspaperService/addNewsResponse")
    public NewspaperResponse addNews(
            @WebParam(name = "news-to-add", partName = "news-to-add")
                    SingleNews newsToAdd);

}
