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

    @Test
    public void getListOfXmlNodesByFindAllOnAttributes() {

        String responseAsString = get(VideoGamesEndpoints.ALL_VIDEO_GAMES).asString();

        List<Node> allDrivingGames = XmlPath.from(responseAsString).get(
                "videoGames.videoGame.findAll { videoGame -> def category = videoGame.@category; category=='Driving' }"
        );

        System.out.println(allDrivingGames.get(0).get("name").toString());
    }

    @Test
    public void getSingleNode() {

        String responseAsString = get(VideoGamesEndpoints.ALL_VIDEO_GAMES).asString();

        Node videoGame = XmlPath.from(responseAsString).get(
                "videoGames.videoGame.find { videoGame -> def name = videoGame.name; name == 'Tetris'}");

        String videoGameName = videoGame.get("name").toString();

        System.out.println(videoGameName);
    }

    @Test
    public void getSingleElementDepthFirst() {

        String responseAsString = get(VideoGamesEndpoints.ALL_VIDEO_GAMES).asString();

        int reviewScore = XmlPath.from(responseAsString).getInt(
                "**.find { it.name == 'Gran Turismo 3'}.reviewScore");

        System.out.println(reviewScore);
    }

    @Test
    public void getAllNodesBasedOnACondition() {

        String responseAsString = get(VideoGamesEndpoints.ALL_VIDEO_GAMES).asString();

        int reviewScore = 90;

        List<Node> allVideoGamesOverCertainScore = XmlPath.from(responseAsString).get(
                "videoGames.videoGame.findAll { it.reviewScore.toFloat() >= " + reviewScore + "}");

        System.out.println(allVideoGamesOverCertainScore);
    }
}
