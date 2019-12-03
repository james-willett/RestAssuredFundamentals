import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestConfig {

    @BeforeClass
    public static void setup() {

        RestAssured.proxy("localhost", 8888);

        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/app/";
        RestAssured.port = 8080;
    }
}
