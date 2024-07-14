package testcases;

import org.testng.annotations.Test;
import pages.Login;

public class LoginTest extends TestBase {

    String username = "Admin";
    String password = "admin123";

    @Test(priority = 1, description = "Login with Valid Username and Password")
    public void loginWithValidData_P() {
        new Login(driver).setUsername(username).setPassword(password).clickLoginButton();
    }
}
