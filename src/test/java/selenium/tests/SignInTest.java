package selenium.tests;

import org.junit.jupiter.api.Test;
import restAssured.User;
import selenium.SeleniumBase;
import selenium.pages.MainPage;
import selenium.pages.PageObject;
import selenium.pages.SignInPage;

import static selenium.Properties.MAIN_CONDUIT_PAGE_URL;

public class SignInTest extends SeleniumBase {

    @Test
    public void SignInTest() {
        User user = new User();
        user.createUser();
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com");
        driver.get(MAIN_CONDUIT_PAGE_URL);
        PageObject pageObject = new PageObject(driver);
        pageObject.clickSignInLink();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.provideEmail(user.getEmail());
        signInPage.providePassword(user.getPassword());
        pageObject.clickSubmitButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitUntilUserProfileLinkIsVisible(user.getUsername());
    }
}
