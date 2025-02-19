
package sasf.jayon.clientsoap.wsdl;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sasf.jayon.clientsoap.wsdl package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sasf.jayon.clientsoap.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductsRequest }
     * 
     */
    public GetProductsRequest createGetProductsRequest() {
        return new GetProductsRequest();
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     * 
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link GetProductRequest }
     * 
     */
    public GetProductRequest createGetProductRequest() {
        return new GetProductRequest();
    }

    /**
     * Create an instance of {@link GetProductResponse }
     * 
     */
    public GetProductResponse createGetProductResponse() {
        return new GetProductResponse();
    }

    /**
     * Create an instance of {@link PostProductRequest }
     * 
     */
    public PostProductRequest createPostProductRequest() {
        return new PostProductRequest();
    }

    /**
     * Create an instance of {@link PostProductResponse }
     * 
     */
    public PostProductResponse createPostProductResponse() {
        return new PostProductResponse();
    }

    /**
     * Create an instance of {@link ProductsList }
     * 
     */
    public ProductsList createProductsList() {
        return new ProductsList();
    }

}
