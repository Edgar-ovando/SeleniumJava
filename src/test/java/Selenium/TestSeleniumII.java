package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class TestSeleniumII {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void loadDriver() throws Exception{
        //Configurar Web driver Manager
        //WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run without GUI
        options.addArguments("--no-sandbox"); // Needed in Docker
        options.addArguments("--disable-dev-shm-usage"); // Avoid shared memory issues

        // Use remote Selenium Hub
        driver = new RemoteWebDriver(
                new URL(System.getenv("SELENIUM_HUB_URL")),
                options
        );

        //Configurar la ruta del chromedriver
        //System.setProperty("webdriver.chrome.driver","/Users/edgar-ovando/Downloads/chromedriver-mac-arm64/chromedriver");

        //Crear una instancia
        //driver = new ChromeDriver();
    }

    // -- Window ALERT
    @Test
    public void windowAlert(){

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://onecompiler.com/html/3xfmfsrwk");

        // Encontrar el button y darle click
        WebElement runbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='hidden sm:flex flex-row justify-between items-center bg-muted']/div[@class='flex items-center justify-center sm:justify-end']//button[text()='RUN ']")));
        runbtn.click();

        //Alerta appear
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Contenido de la alerta: "+alert.getText());
        alert.accept();

    }

    // Window PESTAÑAS
    @Test
    public void windowPestaña(){
        driver.get("https://www.facebook.com/");
        String original = driver.getWindowHandle();

        //Abrir nueva pestaña
        WebDriver newtab = driver.switchTo().newWindow(WindowType.TAB);
        newtab.get("https://www.facebook.com/help/568137493302217");
        String otratab = newtab.getWindowHandle();


        System.out.println(original);
        System.out.println(otratab);
        driver.switchTo().window(original);
    }

    //Window iFrame Pagina web dentro de otra pagina web
    @Test
    public void testIFrame(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

        driver.switchTo().frame("iframeResult");
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));


        WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"tnb-login-btn\"]"));
        iframeElement.click();

    }

    //Espera Explicita
    @Test
    public void testExplicito(){
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys("correoejemplo@gmail.com");

    }

    //Espera Implicita
    @Test
    public void testImplicito(){
        driver.get("https://www.facebook.com/");

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.name("login")));
    }

    //Assert TestNG
    @Test
    public void testAssertion(){
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        //Assert
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    //Cerrar Navegador
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        if(driver != null){
            driver.quit();
        }
    }
}
