import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class TestConfig {

    @BeforeClass
    public static void setup() {

     //   RestAssured.proxy("localhost", 8888);

        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/app/";
        RestAssured.port = 8080;

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        RestAssured.requestSpecification = requestSpecification;
    }
}
