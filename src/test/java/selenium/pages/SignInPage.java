package selenium.pages;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {

    @FindBy(xpath = "//input[@formcontrolname = 'email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@formcontrolname = 'password']")
    public WebElement passwordInput;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void provideEmail(String email) {
        waitUntilElementIsVisible(emailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void providePassword(String password) {
        waitUntilElementIsVisible(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
