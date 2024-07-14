package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import pages.PIMSearch;

public class AddPIMUserTest extends TestBase {

    String FirstName = "abdullah";
    String MidName = "nasr";
    String lastName = "ali";
    String username = "Admin";
    String password = "admin123";
    String employee = "Abdullah";

    @Test
    public void addPIMUser() throws InterruptedException {
        new Login(driver).setUsername(username).setPassword(password).clickLoginButton();
        new PIMSearch(driver).ClickPIM().addUser().setFirstName(FirstName).setMiddleName(MidName).setLastName(lastName).saveButton();
        new PIMSearch(driver).ClickPIM().setEmployee(employee).pressSearchButton();
        Assert.assertTrue(new PIMSearch(driver).verifySuccessmessage("Id"), "not completed");
    }
}
