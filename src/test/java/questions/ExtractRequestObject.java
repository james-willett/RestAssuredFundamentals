package questions;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class ExtractRequestObject {

    protected static final RequestSpecification exampleRequestSpec = new RequestSpecBuilder()
            .addHeader("accept", "application/xml")
            .setBaseUri("http://mywebsite.com")
            .setPort(8080)
            .setBody("My Example Body Text")
            .build();


    @Test
    public void usingRequestSpecificaionImpl() {

        RequestSpecificationImpl requestSpecification = (RequestSpecificationImpl) exampleRequestSpec;

        System.out.println("Request URL = " + requestSpecification.getBaseUri());

        System.out.println("Request Headers = " + requestSpecification.getHeaders().toString());

        System.out.println("Request body = " + requestSpecification.getBody().toString());

    }


}
