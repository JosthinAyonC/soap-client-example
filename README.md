# SOAP-Client creation

1. Agregar el pluggin donde se especifica donde se encontrará el archivo wsdl para así poder descomprimirlo y especificar la ruta de salida.
    
    ```jsx
    <plugin>
    	<groupId>com.sun.xml.ws</groupId>
    	<artifactId>jaxws-maven-plugin</artifactId>
    	<version>3.0.0</version>
    	<executions>
    		<execution>
    			<goals>
    				<goal>wsimport</goal>
    			</goals>
    		</execution>
    	</executions>
    	<configuration>
    		<packageName>sasf.jayon.clientsoap.wsdl</packageName>
    		<wsdlUrls>
    			<wsdlUrl>http://localhost:8080/ws/products.wsdl</wsdlUrl>
    		</wsdlUrls>
    		<sourceDestDir>${project.basedir}/src/main/java</sourceDestDir>
    		<destDir>${classesDir}</destDir>
    		<extension>true</extension>
    	</configuration>
    </plugin>
    ```
    
2. Agregar las configuraciones para el servicio soap que vamos a consumir según la [documentación](https://spring.io/guides/gs/producing-web-service) 
3. Crear los clientes para las entidades o archivos wsdl que tengamos.
4. Especificar las acciones dentro del cliente para que este actúe como un servicio de comunicación cómo en el siguiente ejemplo.
    
    ```jsx
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
    
    ```
    
5. Una vez listo el cliente lo manipularemos como deseemos, en el caso de este proyecto es como la comunicación entre un rest server y un servicio SOAP.