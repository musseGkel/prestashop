package pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocalizationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private By localizationMenu = By.xpath("//body/div[@id='main']/div[1]/nav[1]/ul[1]/li[9]/a[1]/span[1]");
    private By statesLink = By.id("subtab-AdminStates");

    public LocalizationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    public void hoverOnLocalization() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(localizationMenu));
        actions.moveToElement(menu).perform();
    }

    public void clickStates() {
        WebElement states = wait.until(ExpectedConditions.visibilityOfElementLocated(statesLink));
        actions.moveToElement(states).click().perform();
    }
}
