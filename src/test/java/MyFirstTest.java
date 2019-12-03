import config.VideoGameConfig;
import config.VideoGamesEndpoints;
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

    @Test
    public void myFirstTestWithEndpoint() {
        get(VideoGamesEndpoints.ALL_VIDEO_GAMES)
        .then().log().all();
    }
}
