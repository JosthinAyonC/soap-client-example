package sasf.jayon.clientsoap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import sasf.jayon.clientsoap.client.ProductClient;

@Configuration
public class ClientConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("sasf.jayon.clientsoap.wsdl");
        return marshaller;
    }

    @Bean
    public ProductClient productClient(Jaxb2Marshaller marshaller) {
        ProductClient product = new ProductClient();
        product.setDefaultUri("http://localhost:8080/ws");
        product.setMarshaller(marshaller);
        product.setUnmarshaller(marshaller);
        return product;
    }
}
