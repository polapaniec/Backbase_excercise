package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void waitUntilUserProfileLinkIsVisible(String username) {
        String xpath = "//a[@href = '/profile/" + username.toLowerCase() + "']";
        waitUntilElementIsVisible(By.xpath(xpath));
    }
}
