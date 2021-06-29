package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static selenium.Properties.MAIN_CONDUIT_PAGE_URL;

public class PageObject {

    public static final int TIMEOUT_IN_SECONDS = 30;
    public static final int POLLING_TIME_IN_MILLIS = 100;
    @FindBy(linkText = "Sign up")
    public WebElement signUpLink;

    @FindBy(linkText = "Sign in")
    public WebElement signInLink;

    @FindBy(partialLinkText = "Profile")
    public WebElement profileLink;
    protected WebDriver driver;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement submitButton;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public <T> T waitUntilConditionMeet(ExpectedCondition<T> condition) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMEOUT_IN_SECONDS))
                .pollingEvery(Duration.ofMillis(POLLING_TIME_IN_MILLIS))
                .ignoring(NoSuchElementException.class)
                .until(condition);
    }

    public void waitUntilElementIsVisible(By by) {
        waitUntilConditionMeet(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementIsVisible(WebElement element) {
        waitUntilConditionMeet(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsClickable(WebElement element) {
        waitUntilConditionMeet(ExpectedConditions.elementToBeClickable(element));
    }

    public void login() {
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com");
        driver.get(MAIN_CONDUIT_PAGE_URL);
    }

    public void clickSignUpLink() {
        waitUntilElementIsClickable(signUpLink);
        signUpLink.click();
    }

    public void clickSignInLink() {
        waitUntilElementIsClickable(signInLink);
        signInLink.click();
    }

    public void clickSubmitButton() {
        waitUntilElementIsClickable(submitButton);
        submitButton.click();
    }
}
