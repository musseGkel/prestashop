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
import pos.UserMenuPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class AddEmptyProductTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProductsPage productsPage;
    private AddProductPage addProductPage;
    private UserMenuPage userMenuPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        productsPage = new ProductsPage(driver);
        addProductPage = new AddProductPage(driver);
        userMenuPage = new UserMenuPage(driver);
    }

    @Test
    public void testAddNewProduct() {
        loginPage.enterEmail("admin@prestashop.com");
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        dashboardPage.hoverOnCatalog();
        dashboardPage.clickProducts();

        productsPage.clickAddNewProduct();

        addProductPage.clickSave();

        assertTrue(
                addProductPage.isErrorDisplayed("This link_rewrite field is required at least in English (English)"));
        assertTrue(addProductPage.isErrorDisplayed("This name field is required at least in English (English)"));

        userMenuPage.clickUserIcon();
        userMenuPage.clickSignOut();

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
