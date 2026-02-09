package testcases;

import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import org.testng.Assert;

public class TC002LoginTest extends BaseClass {

    @Test
    public void verifyLogin(){
        logger.info(" *** Starting  TC002_LoginTest  ***");

        try{
            //HomePage
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info(" Clicked on My Account button");
            homePage.clickLogin();
            logger.info(" Clicked on Login button");

            //LoginPage
            LoginPage loginPage = new LoginPage(driver);
            logger.info("Provide customer details ...");
            loginPage.setEmail(p.getProperty("email"));
            loginPage.setPassword(p.getProperty("password"));
            loginPage.clickLogin();

            //My Account
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            Boolean targetPage = myAccountPage.isMyAccountDisplayed();

            Assert.assertEquals(targetPage,true,"Login Failed");

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info(" *** Finish  TC002_LoginTest  ***");
    }
}
