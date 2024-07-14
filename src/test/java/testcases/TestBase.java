package testcases;

import com.github.javafaker.Faker;
import common.MyScreenRecorder;
import drivers.DriverFactory;
import drivers.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;
    protected Faker faker = new Faker();

    @Parameters("browser")
    @BeforeTest
    public void setupDriver(@Optional("chrome") String browser) throws Exception {
        // TODO start recording
        MyScreenRecorder.startRecording("Sprint1");

        driver = DriverFactory.getNewInstance(browser);
        DriverHolder.setDriver(driver);

        // TODO set implicit wait
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterTest
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        MyScreenRecorder.stopRecording();
    }
}
