package Bodt.io;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class verifyConnectYourWebsiteButton {
	@Test
	public void verifyLinkConnectYourWebsiteButton() throws InterruptedException
	{
	
		System.out.println("Hello Bodt.io");
		//Launch Chrome Browser
		WebDriver driver= new ChromeDriver();
		 Dimension screenSize = new Dimension(1366, 768); // You can adjust the width and height accordingly
	        driver.manage().window().setSize(screenSize);
		//Maximize Browser

		//Wait until the URl is load and Element to be loaded. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Launch URL on Google.
		driver.get("https:bodt.io");
		
		WebElement connectWebsite = driver.findElement(By.xpath("//a[text()=' Connect Your Website ']"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", connectWebsite);

		if(connectWebsite.isDisplayed() || connectWebsite.isEnabled() || connectWebsite.isSelected())
		{
			connectWebsite.click();
			System.out.println("Verified: The Link clicked.");
		}
		else
		{
			System.out.println("Not Verified: The Link not clicked.");
		}
		Thread.sleep(2000);
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		if(pageTitle.contains("Sign"))
		{
			System.out.println("Verified: sign up page open when click on Link");
		}
		else
			System.out.println("Not Verified: sign up page not open when click on Link");
		Thread.sleep(2000);
		driver.quit();
	}

}
