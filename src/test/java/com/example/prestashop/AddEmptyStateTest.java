package com.example.prestashop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pos.AddStatePage;
import pos.DashboardPage;
import pos.LoginPage;
import pos.LocalizationPage;
import pos.StatesPage;
import pos.UserMenuPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class AddEmptyStateTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LocalizationPage localizationPage;
    private StatesPage statesPage;
    private AddStatePage addStatePage;
    private UserMenuPage userMenuPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        localizationPage = new LocalizationPage(driver);
        statesPage = new StatesPage(driver);
        addStatePage = new AddStatePage(driver);
        userMenuPage = new UserMenuPage(driver);
    }

    @Test
    public void testAddNewState() {
        loginPage.enterEmail("admin@prestashop.com");
        loginPage.enterPassword("password");
        loginPage.clickLogin();
        localizationPage.hoverOnLocalization();
        localizationPage.clickStates();

        statesPage.clickAddNewState();

        addStatePage.clickSave();
        assertTrue(
                addStatePage.isErrorDisplayed("2 errors"));
        assertTrue(
                addStatePage.isErrorDisplayed("The iso_code field is required."));
        assertTrue(
                addStatePage.isErrorDisplayed("The name field is required."));
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
