import config.VideoGameConfig;
import config.VideoGamesEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGameDbTests extends VideoGameConfig {

    @Test
    public void getAllGames() {
        given().
        when().get(VideoGamesEndpoints.ALL_VIDEO_GAMES).
        then();
    }
}
