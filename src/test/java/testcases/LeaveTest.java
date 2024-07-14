package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import pages.Leave;

import static drivers.DriverHolder.getDriver;

public class LeaveTest extends TestBase {
    String username = "Admin";
    String password = "admin123";

    @Test(priority = 1, description = "Login to System with Valid Data")
    public void CheckLeaveText_ISVisiable_P() {
        new Login(driver).setUsername(username).setPassword(password).clickLoginButton();
        new Leave(getDriver()).Click_Leave_MenuButton();
        Assert.assertTrue(new Leave(getDriver()).Verify_Leave_TEXT_IsVisible());
    }
}
