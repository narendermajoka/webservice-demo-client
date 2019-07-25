
package com.idemia.ws.services.impl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.idemia.ws.services.ObjectFactory;
import com.idemia.ws.services.Product;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ProductService", targetNamespace = "http://services.ws.idemia.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProductService {


    /**
     * 
     * @param productId
     * @return
     *     returns com.idemia.ws.services.Product
     */
    @WebMethod(operationName = "GetProductById")
    @WebResult(name = "product", targetNamespace = "")
    @RequestWrapper(localName = "GetProductById", targetNamespace = "http://services.ws.idemia.com/", className = "com.idemia.ws.services.GetProductById")
    @ResponseWrapper(localName = "GetProductByIdResponse", targetNamespace = "http://services.ws.idemia.com/", className = "com.idemia.ws.services.GetProductByIdResponse")
    public Product getProductById(
        @WebParam(name = "productId", targetNamespace = "")
        Integer productId);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(operationName = "ListProducts")
    @WebResult(name = "product", targetNamespace = "")
    @RequestWrapper(localName = "ListProducts", targetNamespace = "http://services.ws.idemia.com/", className = "com.idemia.ws.services.ListProducts")
    @ResponseWrapper(localName = "ListProductsResponse", targetNamespace = "http://services.ws.idemia.com/", className = "com.idemia.ws.services.ListProductsResponse")
    public List<String> listProducts();

}