package questions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.get;

public class MohitGpathFind {

    String theJson = "{\n" +
            "\t\"organicZoneInfo\": {\n" +
            "\t\t\"products\": [{\n" +
            "\t\t\t\"name\": \"ABCD\",\n" +
            "\t\t\t\"ppId\": \"67890\",\n" +
            "\t\t\t\"averageRating\": 4.6923,\n" +
            "\t\t\t\"reviewCount\": 39,\n" +
            "\t\t\t\"priceType\": \"everyday price\",\n" +
            "\t\t\t\"preOrder\": false\n" +
            "\t\t}, {\n" +
            "\t\t\t\"name\": \"EFGH\",\n" +
            "\t\t\t\"ppId\": \"12345\",\n" +
            "\t\t\t\"averageRating\": 4.6923,\n" +
            "\t\t\t\"reviewCount\": 39,\n" +
            "\t\t\t\"priceType\": \"everyday price\",\n" +
            "\t\t\t\"preOrder\": false\n" +
            "\n" +
            "\t\t}]\n" +
            "\t}\n" +
            "}";


    @Test
    public void dummyEndpoint() {

        JsonPath jsonPath = new JsonPath(theJson);

        Map<String, ?> allDetailsForSinglePP = jsonPath.get("organicZoneInfo.products.find { it.ppId == '12345' }");

        System.out.println(allDetailsForSinglePP);

    }

    @Test
    public void actualEndpoint() {

        Response response = get("yourEndpointGoesHere");

        Map<String, ?> allDetailsForSinglePP = response.path("organicZoneInfo.products.find { it.ppId == '12345' }");

        System.out.println(allDetailsForSinglePP);
    }


}
