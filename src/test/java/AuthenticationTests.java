import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class AuthenticationTests {

    @BeforeClass
    public static void setup() {
      //  RestAssured.proxy("localhost", 8888); // only need this if you are running through a proxy
    }
}
