import org.junit.Test;

import static io.restassured.RestAssured.*;

public class MyFirstTest {

    @Test
    public void myFirstTest() {
        given()
                .log().all().
        when().get("http://localhost:8080/app/videogames").
        then().
                log().all();
    }
}
