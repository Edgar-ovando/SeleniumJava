package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//h2[text()='My Account']")
    private WebElement msgHeading;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    private WebElement lnklogout;

    //Actions Methods
    public boolean isMyAccountDisplayed() {

        try {
            return msgHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout() {
        lnklogout.click();
    }


}
