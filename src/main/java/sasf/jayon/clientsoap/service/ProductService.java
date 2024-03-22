package sasf.jayon.clientsoap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.jayon.clientsoap.client.ProductClient;
import sasf.jayon.clientsoap.model.ProductDto;
import sasf.jayon.clientsoap.utils.Mapper;
import sasf.jayon.clientsoap.wsdl.GetProductResponse;
import sasf.jayon.clientsoap.wsdl.GetProductsResponse;
import sasf.jayon.clientsoap.wsdl.PostProductRequest;
import sasf.jayon.clientsoap.wsdl.PostProductResponse;
import sasf.jayon.clientsoap.wsdl.Product;

@Service
public class ProductService {

    @Autowired
    private ProductClient _productClient;

    @Autowired
    private Mapper _map;

    public List<ProductDto> findAll() {
        GetProductsResponse response = _productClient.getAllProduct();
        return _map.mapList(response.getProducts(), ProductDto.class);
    }

    public ProductDto findByName(String name) {
        GetProductResponse response = _productClient.getProductByName(name);
        return _map.mapObject(response.getProduct(), ProductDto.class);
    }

    public ProductDto save(ProductDto productRq) {
        Product product = _map.mapObject(productRq, Product.class);
        PostProductRequest request = new PostProductRequest();
        request.setProduct(product);
        PostProductResponse response = _productClient.saveProduct(request);
        return _map.mapObject(response.getProduct(), ProductDto.class);
    }

}
