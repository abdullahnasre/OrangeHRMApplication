package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Leave {
    // TODO: Step1: Constructor
    WebDriver driver;
    private final By Leave_MenuButton = By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[3]");

    public Leave(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Leave Click_Leave_MenuButton() {
        driver.findElement(this.Leave_MenuButton).click();
        return this;
    }

    private final By Leave_TEXT = By.xpath("//h6[text()='Leave']");

    public boolean Verify_Leave_TEXT_IsVisible() {
        return driver.findElement(this.Leave_TEXT).isDisplayed();
    }
}