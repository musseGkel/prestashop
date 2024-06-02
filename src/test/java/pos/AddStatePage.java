package pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddStatePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By errorMessage = By.xpath("//body/div[@id='main']/div[@id='content']/div[4]/div[1]");

    public AddStatePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterStateName(String stateName) {
        By nameField = By.id("name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(stateName);
    }

    public void enterIsoCode(String isoCode) {
        By isoCodeField = By.id("iso_code");
        wait.until(ExpectedConditions.visibilityOfElementLocated(isoCodeField)).sendKeys(isoCode);
    }

    public void selectCountry(String country) {
        By countryDropdown = By.id("id_country");
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown));
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
    }

    public void selectZone(String zone) {
        By zoneDropdown = By.id("id_zone");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zoneDropdown));
        new Select(driver.findElement(zoneDropdown)).selectByVisibleText(zone);
    }

    public void clickSave() {
        By saveButton = By.id("state_form_submit_btn");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public boolean isStateAdded() {
        By successMessage = By.xpath("//body/div[@id='main']/div[@id='content']/div[4]/div[1]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText()
                .contains("Successful creation");
    }

    public boolean isErrorDisplayed(String errorText) {
        return driver.findElement(errorMessage).getText().contains(errorText);
    }
}
