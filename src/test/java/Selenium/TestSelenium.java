package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;



public class TestSelenium {

    private WebDriver driver;

    @BeforeMethod
    public void loadDriver() throws Exception{

        //Configurar Web driver Manager
        WebDriverManager.chromedriver().setup();

        //Configurar la ruta del chromedriver
        //System.setProperty("webdriver.chrome.driver","/Users/edgar-ovando/Downloads/chromedriver-mac-arm64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run without GUI
        options.addArguments("--no-sandbox"); // Needed in Docker
        options.addArguments("--disable-dev-shm-usage"); // Avoid shared memory issues

        //Crear una instancia
        driver = new ChromeDriver(options);

        /*
        // Use remote Selenium Hub
        driver = new RemoteWebDriver(
                new URL("http://selenium:4444/wd/hub"),
                //new URL(System.getenv("SELENIUM_HUB_URL")),
                options
        );

         */

    }

    @Test
    public void testBrowser(){
        driver.get("https://www.google.com/");

        String titulo =  driver.getTitle();
        Assert.assertEquals("Google",titulo);
    }

   @Test
    public void ingresarTexto(){
        driver.get("https://www.google.com/");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("Historia de Linux");
        searchbox.submit();
    }

    // -- Localizadores Xpath
    @Test
    public void testXPath(){
        driver.get("https://www.google.com/");
        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchbox.sendKeys("Historia de Selenium");
        searchbox.submit();
        //driver.findElement(By.xpath("//*[@id=\"_hrrWaLGbFKzf2roPzuOwkQw_32\"]/div[1]/div/div/div[1]/div[3]/a/div")).click();
    }

    //Manejo de Excepciones
    @Test
    public void testExceptions(){
        driver.get("https://www.google.com/");
        try {
            driver.findElement(By.id("no Existe Id")).click();
        }catch (NoSuchElementException e){
            System.out.println("Error - El elemento no fue encontrado " + e.getMessage());
        }catch (TimeoutException e){
            System.out.println("Error - Tiempo de espera agotado " +e.getMessage());
        }finally {
            //cerrar el navegador
            //driver.quit();
            System.out.println("Se completo el manejo de Exceptions");
        }
    }

    //Cerrar Navegador
    @AfterMethod
    public void closeBrowser(){
        if(driver != null){
            driver.quit();
        }
    }

    //API Testing Pokemon
    /*
    @Test
    public void testGetUser(){
        baseURI = "https://pokeapi.co/api/v2/pokemon/";

        String body = given()
                .when()
                .get("35")
                .then()
                .statusCode(200)

                .extract().body().asString();
        System.out.println(body);
    }*/


}
