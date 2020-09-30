import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class WireMockTest extends WireMockServer {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090);

    @Test
    public void verifyValidCity() {
        //invoking created stub
        setupStub();

        given()
                .body("London")
                .when()
                .get("http://localhost:8090/api/location/44418/2020/9/29/")
                .then()
                .assertThat().statusCode(200)
                .and()
                .assertThat().body("title", org.hamcrest.Matchers.equalTo("London"));
    }

    @Test
    public void verifyInvalidCity() {
        setupStub();

        given()
                .body("XYZ")
                .when()
                .get("http://localhost:8090/api/location/44418/2020/9/29/")
                .then()
                .assertThat().statusCode(404)
                .and()
                .assertThat().body("title", org.hamcrest.Matchers.not("London"));
    }
}
