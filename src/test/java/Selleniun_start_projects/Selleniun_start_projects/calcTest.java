package Selleniun_start_projects.Selleniun_start_projects;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class calcTest {
    
    static WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:/matala/geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        browser.get("https://testpages.eviltester.com/styled/apps/calculator.html");
    }

    @Test
    public void testAddition_1_plus_2() {
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button02")).click();
        browser.findElement(By.id("buttonequals")).click();
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("3", result);
    }

    @Test
    public void testAddition_5_plus_5() {
        browser.findElement(By.id("button05")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button05")).click();
        browser.findElement(By.id("buttonequals")).click();
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("10", result);
    }

    @Test
    public void testSubtraction_5_minus_2() {
        browser.findElement(By.id("button05")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button02")).click();
        browser.findElement(By.id("buttonequals")).click();
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("3", result);
    }

    @Test
    public void testSubtraction_9_minus_9() {
        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonequals")).click();
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("0", result);
    }

    @Test
    public void testMultiplication_3_times_3() {
        browser.findElement(By.id("button03")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button03")).click();
        browser.findElement(By.id("buttonequals")).click();
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("9", result);
    }

    @Test
    public void testMultiplication_1_times_0() {
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button00")).click();
        browser.findElement(By.id("buttonequals")).click();
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("0", result);
    }
    
    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}