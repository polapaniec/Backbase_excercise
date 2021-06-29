package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageObject {

    @FindBy(xpath = "//input[@formcontrolname = 'username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@formcontrolname = 'email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@formcontrolname = 'password']")
    public WebElement passwordInput;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void provideUsername(String username) {
        waitUntilElementIsVisible(usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(username);
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

}
