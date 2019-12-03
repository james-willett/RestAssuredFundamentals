import config.FootballApiConfig;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class FootballApiTests extends FootballApiConfig {

    @Test
    public void getDetailsOfOneArea() {

        given()
                .queryParam("areas", 2255).
        when()
            .get("areas");

    }
}
