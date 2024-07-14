package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIM {
    WebDriver driver;
    private final By firstName = By.xpath("//input[@placeholder='First Name']");
    private final By MiddleName = By.xpath("//input[@placeholder='Middle Name']");
    private final By LastName = By.xpath("//input[@placeholder='Last Name']");
    private final By saveButton = By.xpath("//button[@type='submit']");


    public PIM(WebDriver driver) {
        this.driver = driver;
    }

    public PIM setFirstName(String FirstName) {
        driver.findElement(firstName).sendKeys(FirstName);
        return this;
    }

    public PIM setMiddleName(String MidName) {
        driver.findElement(MiddleName).sendKeys(MidName);
        return this;
    }

    public PIM setLastName(String lastName) {
        driver.findElement(LastName).sendKeys(lastName);
        return this;
    }

    public PIM saveButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(saveButton).click();
        Thread.sleep(5000);
        return this;
    }

}
