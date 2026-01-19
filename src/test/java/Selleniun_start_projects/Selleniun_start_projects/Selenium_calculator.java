package Selleniun_start_projects.Selleniun_start_projects;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Selenium_calculator {
	
	static WebDriver  browser;
	 
	 @Before
	  public void setup() {
		 
 System.setProperty("webdriver.gecko.driver", "C:/matala/geckodriver.exe");
 		      browser = new FirefoxDriver();
		  	  browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			  String url="https://testpages.eviltester.com/apps/button-calculator/";
		      browser.get(url);
		
	  }
	 
	 @Test
		public void Tests1() {
	    	
			
				browser.findElement(By.id("button01")).click();
				browser.findElement(By.id("buttonplus")).click();
				browser.findElement(By.id("button02")).click();
				try {
					  Thread.sleep(1000);
					} catch (InterruptedException e) {
					  Thread.currentThread().interrupt();
					}
				
				browser.findElement(By.id("buttonequals")).click();
				System.out.println("hello");
				
				String result= browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
				System.out.println(result);	
				String Expected= "3";
				assertEquals(Expected,result);
				
				
}}