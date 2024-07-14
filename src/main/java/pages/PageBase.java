package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    private final By SEARCH_BOX = By.xpath("//input[@id='small-searchterms']");


    public PageBase searchFunction(String keyword) {
        driver.findElement(this.SEARCH_BOX).sendKeys(keyword, Keys.ENTER);

        return this;
    }


    public String check_url() {
        return driver.getCurrentUrl();
    }

    public PageBase scroll_down() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,360)", "");
        return this;
    }

    public static void explicitWait(WebDriver driver, By element) {
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public PageBase Wait() throws InterruptedException {
        Thread.sleep(1300);
        return this;
    }
}
