
package com.epam.web.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newspaperResponse", propOrder = {"status", "result"})
public class NewspaperResponse {
    //"http://service.web/"
    @XmlElements({@XmlElement(name = "success", namespace = "http://service.web/", type = StatusSuccess.class),
            @XmlElement(name = "fault", namespace = "http://service.web/", type = StatusFault.class)})
    private Status status;

    @XmlElement(name = "single-news", namespace = "http://service.web/", type = SingleNews.class)
    protected List<Object> result;

    public List<Object> getResult() {
        return this.result;
    }

    public Status getStatus() {
        return this.status;
    }

}






