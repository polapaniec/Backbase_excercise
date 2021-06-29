package restAssured;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static restAssured.ResponseHandler.assertResponseCode;
import static selenium.Properties.*;

public class LoginHelper {

    public static User getToken(User user) {

        Map<String, Map> body = new HashMap<>();
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", user.getEmail());
        credentials.put("password", user.getPassword());
        body.put("user", credentials);

        Response response = given()
                .auth().basic(BASIC_AUTH_USERNAME, BASIC_AUTH_PASSWORD)
                .contentType("application/json")
                .body(body)
                .when()
                .post(MAIN_CONDUIT_PAGE_URL + LOGIN_ENDPOINT);

        assertResponseCode(response, 200);
        user.token = response.jsonPath().get("user.token");
        return user;
    }
}
