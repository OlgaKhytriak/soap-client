
package com.epam.web.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the web.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Success_QNAME = new QName("http://service.web/", "success");
    private final static QName _Fault_QNAME = new QName("http://service.web/", "fault");
    private final static QName _SingleNews_QNAME = new QName("http://service.web/", "single-news");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: web.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SingleNews }
     * 
     */
    public SingleNews createSingleNews() {
        return new SingleNews();
    }

    /**
     * Create an instance of {@link StatusFault }
     * 
     */
    public StatusFault createStatusFault() {
        return new StatusFault();
    }

    /**
     * Create an instance of {@link StatusSuccess }
     * 
     */
    public StatusSuccess createStatusSuccess() {
        return new StatusSuccess();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link NewspaperResponse }
     * 
     */
    public NewspaperResponse createNewspaperResponse() {
        return new NewspaperResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusSuccess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web/", name = "success")
    public JAXBElement<StatusSuccess> createSuccess(StatusSuccess value) {
        return new JAXBElement<StatusSuccess>(_Success_QNAME, StatusSuccess.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web/", name = "fault")
    public JAXBElement<StatusFault> createFault(StatusFault value) {
        return new JAXBElement<StatusFault>(_Fault_QNAME, StatusFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleNews }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web/", name = "single-news")
    public JAXBElement<SingleNews> createSingleNews(SingleNews value) {
        return new JAXBElement<SingleNews>(_SingleNews_QNAME, SingleNews.class, null, value);
    }

}
