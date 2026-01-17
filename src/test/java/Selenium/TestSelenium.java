package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestSelenium {

    private WebDriver driver;

    @BeforeTest
    public void loadDriver(){

        //Configurar Web driver Manager
        WebDriverManager.chromedriver().setup();


        //Configurar la ruta del chromedriver
        //System.setProperty("webdriver.chrome.driver","/Users/edgar-ovando/Downloads/chromedriver-mac-arm64/chromedriver");

        //Crear una instancia
        driver = new ChromeDriver();

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
    @AfterTest
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
