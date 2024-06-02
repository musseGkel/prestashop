package pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By loginButton = By.cssSelector(
            "body.ps_back-office.bootstrap:nth-child(2) div.flip-container:nth-child(3) div.flipper div.front.panel form:nth-child(2) div.form-group.row-padding-top:nth-child(4) > button.btn.btn-primary.btn-lg.btn-block.ladda-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:8080/administrator");
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

}
