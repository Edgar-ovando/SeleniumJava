package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement btnLogin;


    //Action methods
    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }


}
