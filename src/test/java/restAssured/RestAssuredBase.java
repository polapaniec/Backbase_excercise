package restAssured;

import org.junit.jupiter.api.BeforeAll;

public class RestAssuredBase {

    static User baseUser;

    @BeforeAll
    public static void setupTests() {
        baseUser = new User();
        baseUser.createUser();
        baseUser = LoginHelper.getToken(baseUser);
    }
}
