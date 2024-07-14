package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Admin {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By ADMIN = By.linkText("Admin");
    private final By AddAdmin = By.xpath("//button[normalize-space()='Add']");
    private final By AdminDropDown = By.xpath("(//i[@data-v-bddebfba='' and @data-v-67d2aedf='' and contains(@class, 'oxd-icon bi-caret-down-fill oxd-select-text--arrow')])[1]");
    private final By AdminUser = By.xpath("//div[contains(text(),'Admin')]");
    private final By statusDropDown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");  // (//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]
    private final By enabled = By.xpath("//div[@class='oxd-select-text-input' and text()='Enabled']");
    private final By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By userName = By.xpath("(//input[contains(@class, 'oxd-input--active')] )[2]"); // (//input[@class='oxd-input oxd-input--active'])[2]
    private final By password = By.xpath("(//input[@class='oxd-input oxd-input--active' and @type='password' and @autocomplete='off'])[1]");
    private final By confirmPassword = By.xpath("(//input[@type='password'])[2]");         // //*[@id="app"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By searchField = By.xpath("(//input['.oxd-input.oxd-input--focus'])[2]");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By record = By.xpath("//span[normalize-space()='(1) Record Found']");

    public Admin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Admin clickAdminFromMenu()  {
        PageBase.explicitWait(driver,ADMIN);
        driver.findElement(ADMIN).click();
        return this;
    }


    public Admin setEmployee(String EmployeeNameTXT)  {
        driver.findElement(employeeName).sendKeys(EmployeeNameTXT);
        return this;
    }

    public Admin SelectEmployeeName() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(this.employeeName).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.employeeName).sendKeys(Keys.ENTER);
        return this;
    }

    public Admin clickAddAdmin() {
        driver.findElement(AddAdmin).click();
        return this;
    }

    public Admin clickAdminUser() {
        PageBase.explicitWait(driver,AdminDropDown);
        driver.findElement(AdminDropDown).click();
        return this;
    }

    public Admin clickAdminDropdown() throws InterruptedException {
        // Initialize the Actions class
        Actions actions = new Actions(driver);

        // Use the Actions class to press the down arrow key
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // Sleep for a few seconds to observe the action
        Thread.sleep(2000);

        // Optionally, select the highlighted option by pressing ENTER
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public Admin clickStatusDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(statusDropDown)).click();
        return this;
    }

    public Admin clickEnabled() throws InterruptedException {
        // Initialize the Actions class
        Actions actions = new Actions(driver);

        // Use the Actions class to press the down arrow key
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // Sleep for a few seconds to observe the action
        Thread.sleep(2000);

        // Optionally, select the highlighted option by pressing ENTER
        actions.sendKeys(Keys.ENTER).perform();
        return this;

    }

    public Admin setUserName(String employeeUsername) {
        driver.findElement(userName).sendKeys(employeeUsername);
        return this;
    }

    public Admin setPassword(String addPassword) {
        driver.findElement(password).sendKeys(addPassword);
        return this;
    }

    public Admin setConfirmPassword(String addPassword)  {
        PageBase.explicitWait(driver,confirmPassword);
        driver.findElement(confirmPassword).sendKeys(addPassword);
        return this;
    }


    public Admin searchAddedUser(String employeeUsername) {
        PageBase.explicitWait(driver,searchField);
        driver.findElement(searchField).sendKeys(employeeUsername);
        return this;
    }

    public Admin pressSearchButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(searchButton).click();
        return this;
    }

    public Admin save() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(saveButton).click();
        Thread.sleep(6000);
        return this;
    }

    public boolean verifySuccessmessage(String oneRecord) {
        return driver.findElement(record).getText().contains(oneRecord);
    }
}
