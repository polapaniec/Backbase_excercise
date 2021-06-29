package restAssured;

import io.restassured.response.Response;

public class ResponseHandler {

    public static void assertResponseCode(Response response, Integer expectedStatusCode) {
        if (response.statusCode() != expectedStatusCode) {
            throw new RuntimeException("response status code = " + response.statusCode() + ", \n\n" + response.getBody().asPrettyString());
        }
    }
}
