import config.FootballApiConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FootballApiTests extends FootballApiConfig {

    @Test
    public void getDetailsOfOneArea() {

        given()
                .queryParam("areas", 2255).
        when()
            .get("areas");
    }

    @Test
    public void getDateFounded() {
        given().
        when()
                .get("teams/57").
        then()
                .body("founded", equalTo(1886));

    }

    @Test
    public void getFirstTeamName() {
        given().
        when()
                .get("competitions/2021/teams").
        then().
                body("teams.name[0]", equalTo("Arsenal FC"));
    }

    @Test
    public void getAllTeamData() {
        String responseBody = get("teams/57").asString();
        System.out.println(responseBody);
    }

    @Test
    public void getAllTeamData_DoCheckFirst() {
        Response response =
                given().
                        when()
                        .get("teams/57").
                        then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        String jsonResponseAsString = response.asString();
    }

    @Test
    public void extractHeaders() {
        Response response =
                given().
                        when().
                        get("teams/57").
                        then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        Headers headers = response.getHeaders();

        String contentType = response.getHeader("Content-Type");

        System.out.println(contentType);
    }

    @Test
    public void extractFirstTeamName() {
        String firstTeamName = get("competitions/2021/teams").jsonPath().getString("teams.name[0]");

        System.out.println(firstTeamName);
    }

    @Test
    public void extractAllTeamNames() {
        Response response =
                given().
                        when().get("competitions/2021/teams").
                        then().extract().response();

        List<String> teamNames = response.path("teams.name");

        for(String teamName : teamNames) {
            System.out.println(teamName);
        }
    }

}
