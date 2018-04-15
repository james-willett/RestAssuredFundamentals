package questions;

import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ExtractResponseBody {

    String theJson = "[\n" +
            "    {\n" +
            "        \"id\": 1,\n" +
            "        \"country_code\": \"GB\",\n" +
            "        \"country_name\": \"United Kingdom\",\n" +
            "        \"is_active\": true,\n" +
            "        \"is_main\": 1,\n" +
            "        \"website_id\": \"1\",\n" +
            "        \"store_code\": \"gb\",\n" +
            "        \"position\": \"1\",\n" +
            "        \"currency_code\": \"GBP\",\n" +
            "        \"currency_symbol\": \"£\",\n" +
            "        \"base_currency_code\": \"GBP\",\n" +
            "        \"base_currency_symbol\": \"£\",\n" +
            "        \"rate\": 1,\n" +
            "        \"is_mandatory_region\": false,\n" +
            "        \"is_optional_zip\": false,\n" +
            "        \"available_regions\": null,\n" +
            "        \"free_shipping_threshold\": 150\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 2,\n" +
            "        \"country_code\": \"US\",\n" +
            "        \"country_name\": \"United States\",\n" +
            "        \"is_active\": true,\n" +
            "        \"is_main\": 1,\n" +
            "        \"website_id\": \"2\",\n" +
            "        \"store_code\": \"us\",\n" +
            "        \"position\": \"2\",\n" +
            "        \"currency_code\": \"USD\",\n" +
            "        \"currency_symbol\": \"$\",\n" +
            "        \"base_currency_code\": \"USD\",\n" +
            "        \"base_currency_symbol\": \"$\",\n" +
            "        \"rate\": 1,\n" +
            "        \"is_mandatory_region\": true,\n" +
            "        \"is_optional_zip\": false,\n" +
            "        \"available_regions\": [\n" +
            "            {\n" +
            "                \"region_id\": 1,\n" +
            "                \"region_code\": \"AL\",\n" +
            "                \"region\": \"Alabama\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"region_id\": 2,\n" +
            "                \"region_code\": \"AK\",\n" +
            "                \"region\": \"Alaska\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"region_id\": 3,\n" +
            "                \"region_code\": \"AS\",\n" +
            "                \"region\": \"American Samoa\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"region_id\": 4,\n" +
            "                \"region_code\": \"AZ\",\n" +
            "                \"region\": \"Arizona\"\n" +
            "             }\n" +
            "            ]\n" +
            "}\n" +
            "]";


    @Test
    public void test() {
        JsonPath jsonPath = new JsonPath(theJson);

        final List<String> countryNames = jsonPath.get("country_name");

        for (String name : countryNames) {
            if (jsonPath.get("find { it.country_name == \"" + name + "\" }.is_mandatory_region"))
            {
                List<Map<String,?>> regions = jsonPath.get("find { it.country_name == \"" + name + "\" && it.is_mandatory_region == true }.available_regions");
                System.out.println(regions);
            }
        }


    }


}
