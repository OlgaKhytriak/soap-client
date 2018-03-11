
package com.epam.web.service;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for libraryWSResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="libraryWSResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://service.web.epam.com/}book"/>
 *         &lt;element ref="{http://service.web.epam.com/}book" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://service.web.epam.com/}success"/>
 *           &lt;element ref="{http://service.web.epam.com/}fault"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "libraryWSResponse", propOrder = {"status","result"})
public class LibraryWSResponse {
	
	@XmlElements({@XmlElement(name = "success", namespace = "http://service.web.epam.com/", type = LibraryWSStatusSuccess.class),
		@XmlElement(name = "fault", namespace = "http://service.web.epam.com/", type = LibraryWSStatusFault.class)})
	private LibraryWSStatus status;

    @XmlElement(name = "book", namespace = "http://service.web.epam.com/", type = Book.class)
    protected List<Object> result;
    
    
    
    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Book" is used by two different parts of a schema. See: 
     * line 12 of http://localhost:8080/RomanRunkovskyySOAPService-0.0.1-SNAPSHOT/service?xsd=1
     * line 11 of http://localhost:8080/RomanRunkovskyySOAPService-0.0.1-SNAPSHOT/service?xsd=1
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link LibraryWSStatusSuccess }{@code >}
     * {@link JAXBElement }{@code <}{@link Book }{@code >}
     * {@link JAXBElement }{@code <}{@link LibraryWSStatusFault }{@code >}
     * 
     * 
     */
       
    public List<Object> getResult() {
      return this.result;
    }
    
    public LibraryWSStatus getStatus(){
    	return this.status;
    }

}
