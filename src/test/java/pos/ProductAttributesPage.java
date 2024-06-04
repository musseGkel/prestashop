package pos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductAttributesPage {
    private WebDriver driver;
    private By addNewAttributeButton = By.id("page-header-desc-attribute_group-new_attribute_group");

    private WebDriverWait wait;

    public ProductAttributesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddNewAttribute() {
        driver.findElement(addNewAttributeButton).click();
    }

    public void clickEditName(String name) {
        By nameField = By.id("name_1");
        WebElement nameElement = wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameElement.clear();
        nameElement.sendKeys(name);
    }

    public void clickEditPublicName(String publicName) {
        By publicNameField = By.id("public_name_1");
        WebElement publicNameElement = wait.until(ExpectedConditions.elementToBeClickable(publicNameField));
        publicNameElement.clear();
        publicNameElement.sendKeys(publicName);
    }

    public boolean isAttributeAdded() {
        return driver.findElement(By.xpath("//body/div[@id='main']/div[@id='content']/div[4]/div[1]")).isDisplayed();
    }

    public void clickSave() {
        By saveButton = By.id("attribute_group_form_submit_btn");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
