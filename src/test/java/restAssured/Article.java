package restAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static restAssured.ResponseHandler.assertResponseCode;
import static selenium.Properties.*;

public class Article extends RestAssuredBase {

    @Test
    public void postAnArticle() {
        Map<String, Map> body = new HashMap<>();
        Map<String, Object> article = new HashMap<>();
        String title = "R2D2";
        String description = "beepbeep boop?";
        String articleBody = "Can you believe it C3PO?";
        List tags = Arrays.asList("starwars");
        article.put("title", title);
        article.put("description", description);
        article.put("body", articleBody);
        article.put("tagList", tags);
        body.put("article", article);

        Response response = given()
                .auth().basic(BASIC_AUTH_USERNAME, BASIC_AUTH_PASSWORD)
                .header("jwtauthorization", "Token " + baseUser.getToken())
                .contentType("application/json")
                .body(body)
                .when()
                .post(MAIN_CONDUIT_PAGE_URL + CREATE_ARTICLE_ENDPOINT);

        assertResponseCode(response, 200);
        Map<String, Object> articleResponse = response.jsonPath().get("article");
        assertEquals(title, articleResponse.get("title"));
        assertEquals(description, articleResponse.get("description"));
        assertEquals(articleBody, articleResponse.get("body"));
        assertEquals(tags, articleResponse.get("tagList"));
    }
}
