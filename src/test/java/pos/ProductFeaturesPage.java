package pos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductFeaturesPage {
    private WebDriver driver;
    private By addNewFeatureButton = By.id("page-header-desc-feature-new_feature");

    private WebDriverWait wait;

    public ProductFeaturesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddNewFeature() {
        driver.findElement(addNewFeatureButton).click();
    }

    public void clickEditName(String name) {
        By nameField = By.id("name_1");
        WebElement nameElement = wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameElement.clear();
        nameElement.sendKeys(name);
    }

    public boolean isFeatureAdded() {
        return driver.findElement(By.xpath("//body/div[@id='main']/div[@id='content']/div[4]/div[1]")).isDisplayed();
    }

    public void clickSave() {
        By saveButton = By.id("feature_form_submit_btn");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

}
