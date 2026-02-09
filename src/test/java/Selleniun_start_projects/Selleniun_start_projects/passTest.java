package Selleniun_start_projects.Selleniun_start_projects;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class passTest {
    
    static WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:/matala/geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        browser.get("https://testpages.eviltester.com/apps/7-char-val/");
    }

    @Test
    public void testValidPassword() {
        WebElement inputField = browser.findElement(By.name("characters"));
        inputField.clear();
        inputField.sendKeys("Noam123");

        browser.findElement(By.name("validate")).click();

        WebElement resultField = browser.findElement(By.name("validation_message"));
        String actualResult = resultField.getAttribute("value");
        
        Assert.assertEquals("Valid Value", actualResult);
    }


    @Test
    public void testLongPassword() {
        WebElement inputField = browser.findElement(By.name("characters"));
        inputField.clear();
        inputField.sendKeys("yuval123");

        browser.findElement(By.name("validate")).click();

        WebElement resultField = browser.findElement(By.name("validation_message"));
        String actualResult = resultField.getAttribute("value");
        
        Assert.assertEquals("Invalid Value", actualResult);
    }

    @Test
    public void testInvalidCharacter() {
        WebElement inputField = browser.findElement(By.name("characters"));
        inputField.clear();
        inputField.sendKeys("NNY123@");

        browser.findElement(By.name("validate")).click();

        WebElement resultField = browser.findElement(By.name("validation_message"));
        String actualResult = resultField.getAttribute("value");
        
        Assert.assertEquals("Invalid Value", actualResult);
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}