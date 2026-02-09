package testcases;

import pageobjects.HomePage;
import pageobjects.RegistrationPage;
import testbase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001AccountRegistrationTest extends BaseClass {

    @Test
    public void verifyAccountRegistration() {

        logger.info(" *** Starting  TC001_AccountRegistrationTest  ***");

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info(" Clicked on My Account button");

            homePage.clickRegister();
            logger.info(" Clicked on Register button");

            RegistrationPage registrationPage = new RegistrationPage(driver);

            logger.info("Provide customer details ...");
            registrationPage.setFirstname("User" + randomString());
            registrationPage.setLastname("Lastname" + randomString());
            registrationPage.setEmail(randomEmail()); // Generar dynamic data

            logger.info("Validating expected message ...");

            String confmsg = registrationPage.getConfirmationMsg();

            if(confmsg.equals("Your account has been successfully registered."))
            {
                Assert.assertTrue(true);
            }
            else {
                logger.error("Test failed.");
                logger.debug("Debug Logs.");
                Assert.assertTrue(false);;
            }

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info(" *** Finished  TC001_AccountRegistrationTest  ***");

    }


}
