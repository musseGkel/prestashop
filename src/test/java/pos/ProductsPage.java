package pos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private WebDriver driver;
    private By addNewProductButton = By.id("page-header-desc-product-new_product");
    private WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddNewProduct() {
        driver.findElement(addNewProductButton).click();
    }

    public void clickEditProduct(String productName) {
        By editButton = By.xpath("//tr[td[contains(text(), '" + productName + "')]]//a[@title='Edit']");
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

}
