package pos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;
    private By productsMenuItem = By.id("subtab-AdminProducts");
    private By productFeatures = By.id("subtab-AdminFeatures");

    private By productAttributes = By.id("subtab-AdminAttributesGroups");

    private WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
    }

    public void hoverOnCatalog() {
        WebElement catalogMenu = wait
                .until(ExpectedConditions.elementToBeClickable(By
                        .id("maintab-AdminCatalog")));
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogMenu).perform();
    }

    public void clickProducts() {
        driver.findElement(productsMenuItem).click();
    }

    public void clickProductFeatures() {
        driver.findElement(productFeatures).click();
    }

    public void clickProducteAttributes() {
        driver.findElement(productAttributes).click();
    }

}
