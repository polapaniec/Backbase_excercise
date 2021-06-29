package restAssured;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static restAssured.ResponseHandler.assertResponseCode;
import static selenium.Properties.*;

@Data
public class User {
    public String email;
    public String password;
    public String username;
    public String token;

    public User() {
        Faker faker = new Faker();
        this.email = RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@gmail.com";
        this.password = faker.internet().password();
        this.username = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }

    public void createUser() {
        Map<String, Map> body = new HashMap<>();
        Map<String, String> user = new HashMap<>();
        user.put("email", email);
        user.put("username", username);
        user.put("password", password);
        body.put("user", user);

        Response response = given()
                .auth().basic(BASIC_AUTH_USERNAME, BASIC_AUTH_PASSWORD)
                .contentType("application/json")
                .body(body)
                .when()
                .post(MAIN_CONDUIT_PAGE_URL + REGISTRATION_ENDPOINT);

        assertResponseCode(response, 200);
    }
}
