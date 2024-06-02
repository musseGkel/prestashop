package com.example.prestashop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pos.AddProductPage;
import pos.DashboardPage;
import pos.LoginPage;
import pos.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class AddNewProductTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProductsPage productsPage;
    private AddProductPage addProductPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        productsPage = new ProductsPage(driver);
        addProductPage = new AddProductPage(driver);
    }

    @Test
    public void testAddNewProduct() {
        loginPage.enterEmail("admin@prestashop.com");
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        dashboardPage.hoverOnCatalog();
        dashboardPage.clickProducts();

        productsPage.clickAddNewProduct();

        addProductPage.enterProductName("Blue Jacket3");
        addProductPage.clickSave();

        assertTrue(addProductPage.isProductAdded());

        dashboardPage.clickUserIcon();

        loginPage.clickSignOut();

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}