import config.VideoGameConfig;
import config.VideoGamesEndpoints;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GpathXMLTests extends VideoGameConfig {

    @Test
    public void getFirstGameInList() {

        Response response = get(VideoGamesEndpoints.ALL_VIDEO_GAMES);

        String name = response.path("videoGames.videoGame.name[0]");

        System.out.println(name);
    }

    @Test
    public void getAttributeName() {

        Response response = get(VideoGamesEndpoints.ALL_VIDEO_GAMES);

        String category = response.path("videoGames.videoGame[0].@category");

        System.out.println(category);
    }
}
