import config.VideoGameConfig;
import config.VideoGamesEndpoints;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void getListOfXmlNodes() {

        String responseAsString = get(VideoGamesEndpoints.ALL_VIDEO_GAMES).asString();

        List<Node> allResults = XmlPath.from(responseAsString).get(
                "videoGames.videoGame.findAll { element -> return element }"
        );

        System.out.println(allResults.get(2).get("name").toString());
    }
}
