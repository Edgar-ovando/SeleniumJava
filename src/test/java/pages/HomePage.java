package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement lnkMyaccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement lnkRegister;

    @FindBy(linkText="Login")
    private WebElement lnkLogin;

    //Action Methods
    public void clickMyAccount(){
        lnkMyaccount.click();
    }
    public void clickRegister(){
        lnkRegister.click();
    }
    public void clickLogin(){lnkLogin.click();}







}
