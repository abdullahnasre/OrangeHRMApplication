package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMSearch {
    WebDriver driver;
    private final By EmployeeName = By.xpath("(//input['Type for hints...'])[2]");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");
    private final By PIM = By.linkText("PIM");
    private final By record = By.xpath("//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-paper-container']/div[@class='orangehrm-container']/div[@role='table']/div[@role='rowgroup']/div[@role='row']/div[2]");

    public PIMSearch(WebDriver driver) {
        this.driver = driver;
    }

    public PIMSearch setEmployee(String employee) {
        PageBase.explicitWait(driver, EmployeeName);

        driver.findElement(EmployeeName).sendKeys(employee);
        return this;
    }

    public PIMSearch pressSearchButton() {
        PageBase.explicitWait(driver, searchButton);
        driver.findElement(searchButton).click();
        return this;
    }

    public PIM addUser() {
        driver.findElement(addButton).click();
        return new PIM(driver);
    }

    public PIMSearch ClickPIM() {
        driver.findElement(PIM).click();
        return this;
    }


    public boolean verifySuccessmessage(String oneRecord) {
        return driver.findElement(record).getText().contains(oneRecord);
    }
}
