package pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    private By addNewProductButton = By.id("page-header-desc-product-new_product");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddNewProduct() {
        driver.findElement(addNewProductButton).click();
    }
}
