package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleSearch {
  
 @Test
  public void f() {
	 
	 System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 
	 driver.get("http://www.google.com");
	 
	 WebElement searchBox = driver.findElement(By.name("q"));
	 
	 searchBox.sendKeys("Selenium");
	 
	 WebElement searchButton = driver.findElement(By.id("btnG"));
	 searchButton.click();
	 
	 driver.quit();
  }
}
