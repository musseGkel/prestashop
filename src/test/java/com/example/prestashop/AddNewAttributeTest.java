package com.example.prestashop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pos.DashboardPage;
import pos.LoginPage;
import pos.ProductAttributesPage;
import pos.UserMenuPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class AddNewAttributeTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private UserMenuPage userMenuPage;
    private ProductAttributesPage productAttributesPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        userMenuPage = new UserMenuPage(driver);
        productAttributesPage = new ProductAttributesPage(driver);
    }

    @Test
    public void testAddNewProduct() {
        loginPage.enterEmail("admin@prestashop.com");
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        dashboardPage.hoverOnCatalog();
        dashboardPage.clickProducteAttributes();

        productAttributesPage.clickAddNewAttribute();
        productAttributesPage.clickEditName("Quantity");
        productAttributesPage.clickEditPublicName("Qnt");
        productAttributesPage.clickSave();

        assertTrue(productAttributesPage.isAttributeAdded());

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
