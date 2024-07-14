package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import pages.PageBase;
import pages.Recruitment;
public class RecruitmentTest extends TestBase {

    @Test(priority = 1,description = "Login to System with Valid Data")
    public void navigate_to_recruitment_page_P() throws InterruptedException {
        String username = "Admin";
        String password = "admin123";

        new Login(driver).setUsername(username).setPassword(password).clickLoginButton();
        new PageBase(driver).Wait();
        new Recruitment(driver).click_link();
        new PageBase(driver).Wait();
        Assert.assertEquals( new Recruitment(driver).verify_url(),"https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
        Assert.assertTrue( new Recruitment(driver).verify_title(),"navigation faild");
    }
}