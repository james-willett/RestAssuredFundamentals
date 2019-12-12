import config.VideoGameConfig;
import config.VideoGamesEndpoints;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

public class VideoGameDbTests extends VideoGameConfig {

    @Test
    public void getAllGames() {
        given().
        when().get(VideoGamesEndpoints.ALL_VIDEO_GAMES).
        then();
    }

    @Test
    public void createNewGameByJSON() {
        String gameBodyJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyNewGame\",\n" +
                "  \"releaseDate\": \"2019-12-03T10:02:58.768Z\",\n" +
                "  \"reviewScore\": 88,\n" +
                "  \"category\": \"Shooter\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";

        given()
                .body(gameBodyJson).
        when()
                .post(VideoGamesEndpoints.ALL_VIDEO_GAMES).
        then();
    }

    @Test
    public void createNewGameByXML() {
        String gameBodyXml = "  <videoGame category=\"Shooter\" rating=\"Universal\">\n" +
                "    <id>13</id>\n" +
                "    <name>Resident Evil 8</name>\n" +
                "    <releaseDate>2005-10-01T00:00:00+01:00</releaseDate>\n" +
                "    <reviewScore>99</reviewScore>\n" +
                "  </videoGame>";

        given()
               .body(gameBodyXml)
               .header("Accept", "application/xml")
               .header("Content-Type", "application/xml").
        when()
                .post(VideoGamesEndpoints.ALL_VIDEO_GAMES).
        then();

    }

    @Test
    public void updateGame() {

        String gameBodyJson = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"MyNewGame\",\n" +
                "  \"releaseDate\": \"2019-12-03T10:02:58.768Z\",\n" +
                "  \"reviewScore\": 77,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Universal\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().
                put("videogames/1").
        then();
    }

    @Test
    public void deleteGame() {
        given().
        when()
                .delete("videogames/1").
        then();
    }

    @Test
    public void getSingleGame() {
        given()
                .pathParam("videoGameId", 5).
        when()
                .get(VideoGamesEndpoints.SINGLE_VIDEO_GAME).
        then();
    }

    @Test
    public void testVideoGameSerializationByJSON() {
        VideoGame videoGame = new VideoGame("99", "2018-04-04", "My Awesome Game", "Mature", "15", "Shooter");

        given().
                body(videoGame).
        when().
               post(VideoGamesEndpoints.ALL_VIDEO_GAMES).
        then();
    }

    @Test
    public void testVideoGameSchemaXML() {
        given().
                pathParam("videoGameId", 5).
                header("Content-Type", "application/xml").
                header("Accept", "application/xml").
        when().
                get(VideoGamesEndpoints.SINGLE_VIDEO_GAME).
        then().
                body(matchesXsdInClasspath("VideoGameXSD.xsd"));
    }

    @Test
    public void testVideoGameSchemaJSON() {
        given().
                pathParam("videoGameId", 5).
        when().
                get(VideoGamesEndpoints.SINGLE_VIDEO_GAME).
        then().
                body(matchesJsonSchemaInClasspath("VideoGameJsonSchema.json"));
    }

    @Test
    public void convertJSONToPojo() {
        Response response =  given().pathParam("videoGameId", 5).
                when().
                get(VideoGamesEndpoints.SINGLE_VIDEO_GAME);

        VideoGame videoGame = response.getBody().as(VideoGame.class);

        System.out.println(videoGame.toString());
    }

    @Test
    public void captureResponseTime() {
        long responseTime = get(VideoGamesEndpoints.ALL_VIDEO_GAMES).time();
        System.out.println("Response time in MS: " + responseTime);
    }

    @Test
    public void assertOnResponseTime() {
        when().
                get(VideoGamesEndpoints.ALL_VIDEO_GAMES).
        then().
                time(lessThan(1000L));
    }




}
