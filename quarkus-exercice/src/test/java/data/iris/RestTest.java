package data.iris;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
public class RestTest {

    @Test
    public void testHelloEndpoint() {
        given().
                when()
                .get("repository/fruits/test").
                then()
                .statusCode(200)
                .body(startsWith("This is a test."));
    }


}
