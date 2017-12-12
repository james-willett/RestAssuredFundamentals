import config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GPathJSONTests extends TestConfig {

    @Test
    public void extractMapOfElementsWithFind() {

        Response response = get("competitions/426/teams");

        Map<String,?> allTeamDataForSingleTeam = response.path
                ("teams.find { it.name == 'Leicester City FC' }");

        System.out.println(allTeamDataForSingleTeam);
    }

    @Test
    public void extractSingleValueWithFind() {

        Response response = get("teams/66/players");
        String certainPlayer = response.path("players.find { it.jerseyNumber == 20}.name");
        System.out.println(certainPlayer);
    }

    @Test
    public void extractListOfValuesWithFindAll() {

        Response response = get("teams/66/players");
        List<String> playerNames = response.path("players.findAll { it.jerseyNumber > 10}.name");
        System.out.println(playerNames);
    }

    @Test
    public void extractSingleValueWithHighestNumber() {

        Response response = get("teams/66/players");
        String playerName = response.path("players.max { it.jerseyNumber }.name");
        System.out.println(playerName);
    }

    @Test
    public void extractMultipleValuesAndSumThem() {

        Response response = get("teams/66/players");
        int sumOfJerseys = response.path("players.collect { it.jerseyNumber }.sum()");
        System.out.println(sumOfJerseys);
    }

    @Test
    public void extractMapOfObjectWithFindAndFindAll() {

        String position = "Centre-Back";
        String nationality = "Argentina";

        Response response = get("teams/66/players");
        Map<String,?> playerOfCertainPosition = response.path(
                "players.findAll { it.position == '%s' }.find { it.nationality == '%s' }",
                position, nationality);
        System.out.println(playerOfCertainPosition);
    }

    @Test
    public void extractMultiplePlayers() {

        String position = "Centre-Back";
        String nationality = "England";

        Response response = get("teams/66/players");
        ArrayList<Map<String,?>> allPlayersCertainNation = response.path(
                "players.findAll { it.position == '%s' }.findAll { it.nationality == '%s' }",
                position, nationality);

        System.out.println(allPlayersCertainNation);

    }


}
