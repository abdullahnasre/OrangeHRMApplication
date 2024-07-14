package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends PageBase {
    WebDriver driver;
    private final By USERNAME = By.xpath("//input[@placeholder='Username']");
    private final By PASSWORD = By.xpath("//input[@placeholder='Password']");
    private final By LoginBUTTON = By.xpath("//button[@type='submit']");


    public Login(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Login setUsername(String username) {
        driver.findElement(USERNAME).sendKeys(username);
        return this;
    }

    public Login setPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    public Login clickLoginButton() {
        driver.findElement(LoginBUTTON).click();
        return this;
    }
}
