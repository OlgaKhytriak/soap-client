
package com.epam.web.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "NewspaperServiceImplService", targetNamespace = "http://impl.service.web/", wsdlLocation = "http://localhost:8080/NewspaperService?wsdl")
public class NewspaperServiceImplService
    extends Service
{

    private final static URL NEWSPAPERSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException NEWSPAPERSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName NEWSPAPERSERVICEIMPLSERVICE_QNAME = new QName("http://impl.service.web/", "NewspaperServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/NewspaperService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NEWSPAPERSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        NEWSPAPERSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public NewspaperServiceImplService() {
        super(__getWsdlLocation(), NEWSPAPERSERVICEIMPLSERVICE_QNAME);
    }

    public NewspaperServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), NEWSPAPERSERVICEIMPLSERVICE_QNAME, features);
    }

    public NewspaperServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, NEWSPAPERSERVICEIMPLSERVICE_QNAME);
    }

    public NewspaperServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NEWSPAPERSERVICEIMPLSERVICE_QNAME, features);
    }

    public NewspaperServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NewspaperServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NewspaperService
     */
    @WebEndpoint(name = "NewspaperServiceImplPort")
    public NewspaperService getNewspaperServiceImplPort() {
        return super.getPort(new QName("http://impl.service.web/", "NewspaperServiceImplPort"), NewspaperService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NewspaperService
     */
    @WebEndpoint(name = "NewspaperServiceImplPort")
    public NewspaperService getNewspaperServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.service.web/", "NewspaperServiceImplPort"), NewspaperService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NEWSPAPERSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw NEWSPAPERSERVICEIMPLSERVICE_EXCEPTION;
        }
        return NEWSPAPERSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
