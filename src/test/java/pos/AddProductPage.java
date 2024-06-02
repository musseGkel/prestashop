package pos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductPage {
    private WebDriver driver;
    private By nameField = By.id("name_1");
    private By saveButton = By.xpath(
            "//body/div[@id='main']/div[@id='content']/div[6]/div[1]/div[1]/form[1]/div[1]/div[1]/div[16]/button[1]/i[1]");
    private By errorMessage = By.xpath(
            "//body/div[@id='main']/div[@id='content']/div[4]/div[1]");
    private WebDriverWait wait;
    private By successMessage = By.cssSelector("div.alert.alert-success");

    public AddProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterProductName(String productName) {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        nameElement.clear();
        nameElement.sendKeys(productName);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton)).click();
    }

    public boolean isProductAdded() {
        return driver.findElement(By.xpath("//body/div[@id='main']/div[@id='content']/div[4]/div[1]")).isDisplayed();
    }

    public boolean isErrorDisplayed(String errorText) {
        return driver.findElement(errorMessage).getText().contains(errorText);
    }

    public boolean isProductUpdated() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText()
                .contains("Successful update");
    }
}
