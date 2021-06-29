package restAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static restAssured.ResponseHandler.assertResponseCode;
import static selenium.Properties.*;

public class Profile extends RestAssuredBase {

    @Test
    public void getProfile() {
        Response response = given()
                .auth().basic(BASIC_AUTH_USERNAME, BASIC_AUTH_PASSWORD)
                .header("jwtauthorization", "Token " + baseUser.getToken())
                .contentType("application/json")
                .when()
                .get(MAIN_CONDUIT_PAGE_URL + GET_PROFILE_ENDPOINT + baseUser.getUsername());

        assertResponseCode(response, 200);
        Map<String, Object> getProfileResponse = response.jsonPath().get("profile");
        assertEquals(baseUser.getUsername(), getProfileResponse.get("username"));
        assertFalse((Boolean) getProfileResponse.get("following"));
    }
}
