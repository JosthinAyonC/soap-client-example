package sasf.jayon.clientsoap.client;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import sasf.jayon.clientsoap.wsdl.GetProductRequest;
import sasf.jayon.clientsoap.wsdl.GetProductResponse;
import sasf.jayon.clientsoap.wsdl.GetProductsRequest;
import sasf.jayon.clientsoap.wsdl.GetProductsResponse;
import sasf.jayon.clientsoap.wsdl.PostProductRequest;
import sasf.jayon.clientsoap.wsdl.PostProductResponse;

@Service
public class ProductClient extends WebServiceGatewaySupport {

    public GetProductResponse getProductByName(String product) {

        try {
            GetProductRequest request = new GetProductRequest();
            request.setName(product);

            GetProductResponse response = (GetProductResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8080/ws/products", request);

            return response;
        } catch (Exception e) {
            return null;
        }
    }

    public GetProductsResponse getAllProduct() {

        try {
            GetProductsRequest request = new GetProductsRequest();

            GetProductsResponse response = (GetProductsResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8080/ws/products", request);

            return response;
        } catch (Exception e) {
            return null;
        }
    }

    public PostProductResponse saveProduct(PostProductRequest request) {
        try {
            PostProductResponse response = (PostProductResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8080/ws/products", request);
            return response;
        } catch (Exception e) {
            return null;
        }
    }
}
