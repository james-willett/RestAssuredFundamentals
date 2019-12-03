import org.junit.Test;

import static io.restassured.RestAssured.*;

public class MyFirstTest extends TestConfig {

    @Test
    public void myFirstTest() {
        given()
                .log().all().
        when().get("videogames").
        then().
                log().all();
    }
}
