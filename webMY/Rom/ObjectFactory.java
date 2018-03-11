
package com.epam.web.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.web.service package. 
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

    private final static QName _Success_QNAME = new QName("http://service.web.epam.com/", "success");
    private final static QName _Book_QNAME = new QName("http://service.web.epam.com/", "book");
    private final static QName _Fault_QNAME = new QName("http://service.web.epam.com/", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.web.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LibraryWSStatusSuccess }
     * 
     */
    public LibraryWSStatusSuccess createLibraryWSStatusSuccess() {
        return new LibraryWSStatusSuccess();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link LibraryWSStatusFault }
     * 
     */
    public LibraryWSStatusFault createLibraryWSStatusFault() {
        return new LibraryWSStatusFault();
    }

    /**
     * Create an instance of {@link LibraryWSStatus }
     * 
     */
    public LibraryWSStatus createLibraryWSStatus() {
        return new LibraryWSStatus();
    }

    /**
     * Create an instance of {@link LibraryWSResponse }
     * 
     */
    public LibraryWSResponse createLibraryWSResponse() {
        return new LibraryWSResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LibraryWSStatusSuccess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.epam.com/", name = "success")
    public JAXBElement<LibraryWSStatusSuccess> createSuccess(LibraryWSStatusSuccess value) {
        return new JAXBElement<LibraryWSStatusSuccess>(_Success_QNAME, LibraryWSStatusSuccess.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.epam.com/", name = "book")
    public JAXBElement<Book> createBook(Book value) {
        return new JAXBElement<Book>(_Book_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LibraryWSStatusFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.epam.com/", name = "fault")
    public JAXBElement<LibraryWSStatusFault> createFault(LibraryWSStatusFault value) {
        return new JAXBElement<LibraryWSStatusFault>(_Fault_QNAME, LibraryWSStatusFault.class, null, value);
    }

}
