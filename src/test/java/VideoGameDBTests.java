import config.EndPoint;
import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

public class VideoGameDBTests extends TestConfig {

    @Test
    public void getAllGames() {

        given().
        when().get(EndPoint.VIDEOGAMES).
        then();
    }

    @Test
    public void createNewGameByJSON() {

        String gameBodyJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyNewGame\",\n" +
                "  \"releaseDate\": \"2017-12-07T11:49:25.712Z\",\n" +
                "  \"reviewScore\": 50,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().
                post(EndPoint.VIDEOGAMES).
        then();

    }

    @Test
    public void createNewGameByXML() {

        String gameBodyXml = "<videoGame category=\"Shooter\" rating=\"Universal\">\n" +
                "    <id>12</id>\n" +
                "    <name>Resident Evil 7</name>\n" +
                "    <releaseDate>2005-10-01T00:00:00+01:00</releaseDate>\n" +
                "    <reviewScore>75</reviewScore>\n" +
                "  </videoGame>";

        given().
                body(gameBodyXml).
        when().
                post(EndPoint.VIDEOGAMES).
        then();
    }

    @Test
    public void updateGame() {

        String gameBodyJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyUpdatedGame\",\n" +
                "  \"releaseDate\": \"2017-12-07T11:49:25.712Z\",\n" +
                "  \"reviewScore\": 99,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().
                put("/videogames/11").
        then();

    }

    @Test
    public void deleteGame() {

        given().
        when().
                delete("/videogames/11").
        then();
    }

    @Test
    public void getSingleGame() {

        given().
                pathParam("videoGameId", 5).
        when().
                get(EndPoint.SINGLE_VIDEOGAME);
    }

    @Test
    public void testVideoGameSerialisationByJSON() {

        VideoGame videoGame = new VideoGame("15", "shooter", "2014-06-06", "Halo 5", "Mature", "89");

        given().
                body(videoGame).
        when().
                post(EndPoint.VIDEOGAMES).
                then();
    }


    @Test
    public void testVideoGameSchemaXML() {

        given().
                pathParam("videoGameId", 5).
        when().
                get(EndPoint.SINGLE_VIDEOGAME).
        then().
                body(matchesXsdInClasspath("VideoGame.xsd"));
    }

    @Test
    public void testVideoGameSchemaJSON() {
        given().
                pathParam("videoGameId", 5).
        when().
                get(EndPoint.SINGLE_VIDEOGAME).
        then().
                body(matchesJsonSchemaInClasspath("VideoGameJsonSchema.json"));
    }





}
