package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Admin;
import pages.Login;

import static drivers.DriverHolder.getDriver;
import static util.Utility.generateUsername;

public class AddAdminTest extends TestBase {
    String NewEmployeeName_fakerDate = faker.regexify("[aef]");
    String employeeUsername = generateUsername(8, 10);
    String addPassword = "P@ssword1";
    String username = "Admin";
    String password = "admin123";

    @Test
    public void AddAdminWithValidData_P() throws InterruptedException {
        new Login(driver).setUsername(username).setPassword(password).clickLoginButton();
        new Admin(driver).clickAdminFromMenu().clickAddAdmin();
        new Admin(driver).setUserName(employeeUsername).SelectEmployeeName().setPassword(addPassword).setConfirmPassword(addPassword);
        new Admin(driver).setEmployee(NewEmployeeName_fakerDate).SelectEmployeeName().clickAdminUser().clickAdminDropdown().clickStatusDropDown().clickEnabled().save();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        new Admin(driver).searchAddedUser(employeeUsername).pressSearchButton();
        Assert.assertTrue(new Admin(driver).verifySuccessmessage("(1) Record Found"), "not completed");
    }
}
