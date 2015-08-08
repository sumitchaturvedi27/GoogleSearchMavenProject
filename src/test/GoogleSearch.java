package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.*;
import org.apache.ws.commons.serialize.DOMSerializer;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class GoogleSearch {
  
	public static String DEVKEY="fcb75a5d649ed079300b46195d2616ac";
	
	public static String URL = "http://localhost//testlink//lib//api//xmlrpc//v1//xmlrpc.php";
	
	public void reportResult(String testProject, String testPlan, String testCase, String Build, String Notes, String Result) throws TestLinkAPIException {
		
		TestLinkAPIClient api = new TestLinkAPIClient (DEVKEY, URL);
		
		api.reportTestCaseResult(testProject, testPlan, testCase, Build, Notes, Result);
		
	}
  @Test
  public void searchGoogle () throws TestLinkAPIException {
	  
	 
	  
	  System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
	  
	  WebDriver driver = new ChromeDriver();

	  GoogleSearch t = new GoogleSearch();
	  
	  String testProject="GoogleSearch_Project";
	  String testPlan="GSP-TestPlan";
	  String testSuite="GSP-TS1";
	  String testCase="GSP-1";
	  String Build="GSP-9.5.4.160";
	  String Notes=null;
	  String Result=null;
	  
	  try {
	  driver.get("http://www.google.com");
	  
	  WebElement searchText = driver.findElement(By.name("q"));
	  searchText.sendKeys("LearnSelenium");
	  
	  
	  WebElement searchButton = driver.findElement(By.name("btnG"));
	  searchButton.click();
	  
	  
	  
	  Result = TestLinkAPIResults.TEST_PASSED;
	  Notes = "Executed Successfully";
	  } catch (Exception e) {
		  Result = TestLinkAPIResults.TEST_FAILED;
		  Notes = "Executed Failed";
	  }
	  finally {
		  t.reportResult(testProject, testPlan, testCase, Build, Notes, Result);
		  driver.quit();
	  }
  }
}

