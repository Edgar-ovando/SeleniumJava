package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;   //Log4j
import org.testng.annotations.Parameters;

public class BaseClass {

     protected Logger logger; //Log4j
     protected WebDriver driver;
     protected Properties p;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {

        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        switch (br.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                //WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                //WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + br);
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(p.getProperty("appURL"));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    // Methods

    public String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(15);
        return generatedString;
    }

    public String randomNumber() {
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }

    public String randomEmail() {
        String generatedString = RandomStringUtils.randomNumeric(4);
        return ("automatedEmail" + generatedString + "@gmail.com");
    }

    public String randomAlphaNumeric() {
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return (generatedNumber + generatedString);
    }


}
