package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class TestConfig {

    public static RequestSpecification videoGame_requestSpec;
    public static RequestSpecification football_requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setup() {

        RestAssured.proxy("localhost", 8888); // comment this out if you aren't running REST Assured through a proxy

        /* Request Specifications */
        videoGame_requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(8080).
                setBasePath("/app/").
                addHeader("Content-Type", "application/xml"). // change between "application/xml" and "application/json" as required
                addHeader("Accept", "application/xml"). // change between "application/xml" and "application/json" as required
                build();

        football_requestSpec = new RequestSpecBuilder().
                setBaseUri("http://api.football-data.org").
                setBasePath("/v1/").
                addHeader("X-Auth-Token", "fae8b099875d41f395c58dbb7f35556b").
                addHeader("X-Response-Control", "minified").
                build();


        RestAssured.requestSpecification = videoGame_requestSpec; // change this to football_requestSpec or videoGame_requestSpec as required


        /* Response Specifications */
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectResponseTime(lessThan(30000L)).
                build();

        RestAssured.responseSpecification = responseSpec;

    }
}
