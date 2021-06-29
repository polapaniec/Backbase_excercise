package selenium.tests;

import org.junit.jupiter.api.Test;
import restAssured.User;
import selenium.SeleniumBase;
import selenium.pages.MainPage;
import selenium.pages.PageObject;
import selenium.pages.SignUpPage;

public class SignUpTest extends SeleniumBase {

    @Test
    public void signUp() {
        PageObject pageObject = new PageObject(driver);
        pageObject.login();
        pageObject.clickSignUpLink();
        SignUpPage signUpPage = new SignUpPage(driver);
        User user = new User();
        signUpPage.provideUsername(user.getUsername());
        signUpPage.provideEmail(user.getEmail());
        signUpPage.providePassword(user.getPassword());
        pageObject.clickSubmitButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitUntilUserProfileLinkIsVisible(user.getUsername());
    }


}
