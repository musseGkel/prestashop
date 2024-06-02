package pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StatesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public StatesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddNewState() {
        By addNewStateButton = By.id("page-header-desc-state-new_state");
        wait.until(ExpectedConditions.elementToBeClickable(addNewStateButton)).click();
    }
}
