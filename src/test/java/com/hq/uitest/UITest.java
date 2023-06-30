package com.hq.uitest;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UITest {


    public WebDriver driver;

    @BeforeEach
    public void Setup()
    {
        GetDriverSetup();
        driver.get("https://d3ovkzfkbrwp1z.cloudfront.net/");

    }

  //  @Test
    public void Init() throws InterruptedException {
//Thread.sleep(1000);
       driver.findElement(By.cssSelector("[aria-label=contact]")).click();
       driver.findElement(By.id("forename")).sendKeys("Dan");
        driver.findElement(By.id("email")).sendKeys("dan@abc.com");
        driver.findElement(By.id("message")).sendKeys("Nice Pizza");
        driver.findElement(By.cssSelector("[aria-label=submit]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.className("v-alert__content"))));

        Assert.assertEquals("Thanks Dan, we appreciate your feedback",driver.findElement(By.className("v-alert__content")).getText());

    }

    @Test
    public  void TestNewSideDish()
    {
        driver.findElement(By.cssSelector("[aria-label=menu]")).click();

       // new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("[role=tab] v-tab"))));
        for(WebElement element:driver.findElements(By.className("v-tab")))
        {


            System.out.println(element.getText());


            if(element.getText().equalsIgnoreCase("SIDES"))
            {

                System.out.println(element.getText());
               element.click();
            }
        }



//        for(WebElement element:driver.findElements(By.className("flex mb-2 mt-5 xs12 sm6 md3 lg2")))
//        {
//
//            System.out.println(element.getText());
//
//
//            if(element.getText().equalsIgnoreCase("Korean Sticky Wings"))
//            {
//
//                System.out.println(element.getText());
//                element.click();
//            }
//        }


    }

    @AfterEach
    public  void Close()
    {
        //driver.quit();
    }

    public void GetDriverSetup()
    {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);

    }


}
