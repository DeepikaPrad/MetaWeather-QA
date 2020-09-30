import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockServer {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090);

    public void setupStub() {

        stubFor(get(urlEqualTo("/api/location/44418/2020/9/29/"))
                .withRequestBody(matching("London"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/JSON")
                        .withStatus(200)
                        .withBody("{\"title\":\"London\"}")));

        stubFor(get(urlEqualTo("/api/location/44418/2020/9/29/"))
                .withRequestBody(notMatching("London"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/JSON")
                        .withStatus(404)
                        .withBody("{\"title\":\"\"}")));
    }
}
