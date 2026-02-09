package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verifyLoginDDT(String email, String password, String expectedResult) {

        logger.info("*** Starting  TC003_LoginDDTTest  ***");

        //HomePage
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        logger.info(" Clicked on My Account button");
        homePage.clickLogin();
        logger.info(" Clicked on Login button");

        //LoginPage
        LoginPage loginPage = new LoginPage(driver);
        logger.info("Provide customer details ...");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        //My Account
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Boolean targetPage = myAccountPage.isMyAccountDisplayed();

        if (expectedResult.equalsIgnoreCase("Valid")) {

            if (targetPage) {
                myAccountPage.clickLogout();
                myAccountPage.clickLogin();
                Assert.assertTrue(true);
            } else Assert.assertTrue(false);

        }
        if (expectedResult.equalsIgnoreCase("Invalid")) {

            if (targetPage) {

                myAccountPage.clickLogout();
                myAccountPage.clickLogin();
                Assert.assertTrue(false);

            }else Assert.assertTrue(true);

        }

        logger.info("*** Finish  TC003_LoginDDTTest  ***");

    }
}
