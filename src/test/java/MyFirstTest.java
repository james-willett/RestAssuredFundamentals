import config.VideoGameConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class MyFirstTest extends VideoGameConfig {

    @Test
    public void myFirstTest() {
        given()
                .log().all().
        when().get("videogames").
        then().
                log().all();
    }
}
