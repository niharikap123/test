package com.facebook.page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

    public class MasterPage {
	
	public WebDriver driver;
	
	public Properties pr;
	
	public Actions act;

	public	MasterPage() throws IOException {
	 
	FileInputStream fs = new FileInputStream("E:\\eclipse-workspace\\PageObjectModelAprJrp\\src\\OR.properties");
		
	pr = new Properties();
		
	pr.load(fs);
		
	if(pr.getProperty("browser").equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver = new ChromeDriver(options);
			
			
	}
	
	else if(pr.getProperty("browser").equalsIgnoreCase("firefox")) {
		
		System.setProperty("webdriver.gecko.driver", "E:\\firefox\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		
	}
	
	else {
		
		System.setProperty("webdriver.edge.driver", "E:\\edgedriver\\msedgedriver.exe");
		
		driver = new EdgeDriver();
			
		
	}
		
		driver.get("https://www.facebook.com");
		
		driver.manage().window().maximize();
		
}	
	
	public void sendkeys(String xpathkey, String userdata) {
		

	   driver.findElement(By.xpath(pr.getProperty(xpathkey))).sendKeys(userdata);
		      
	 
 }
	
   public void clickbutton(String xpathbutton){
	   
	   driver.findElement(By.xpath(pr.getProperty(xpathbutton))).click();
	   
	    
	   
   }
   
   public boolean isLinkPresent(String xpathhome) {
	   
	 try {
	   
	 driver.findElement(By.xpath(pr.getProperty(xpathhome)));
	 
	 return true;
	 
	 }
	 
	 catch(Exception e) {
		 
	  return false;
		 
	 }
	   
   }
   
   public void edgeacts() {
	   
	   if(pr.getProperty("browser").equalsIgnoreCase("edge")) {
	   
	    act = new Actions(driver);
		
		act.sendKeys(Keys.ESCAPE).build().perform();
		
	}
	   
  }
   
 
}
