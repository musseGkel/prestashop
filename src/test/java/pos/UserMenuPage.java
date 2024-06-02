package pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserMenuPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userIcon = By.xpath("//header/nav[@id='header_infos']/div[1]/ul[3]/li[3]/a[1]/span[1]/img[1]");
    private By signOutLink = By.id("header_logout");

    public UserMenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickUserIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
    }

    public void clickSignOut() {
        wait.until(ExpectedConditions.elementToBeClickable(signOutLink)).click();
    }
}
