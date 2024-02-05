package Bodt.io;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class verifyLearnMoreLinkOFConnectYourWebsite {

	@Test
	public void learnMoreLink() throws InterruptedException
	
	{
		System.out.println("Hello Bodt.io");
		//Launch ChromeBrowser
		WebDriver driver= new ChromeDriver();
		//Maximize Browser
		driver.manage().window().maximize();
		//Wait until the URl is load and Element to be loaded. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Launch URL on Google.
		driver.get("https:bodt.io");
		
		WebElement learnMoreLink = driver.findElement(By.xpath("//a[text()='Learn more ']"));
		Actions action = new Actions(driver);
		action.moveToElement(learnMoreLink).perform();
		
		if(learnMoreLink.getText().contains("Learn more"))
		{
			learnMoreLink.click();
			System.out.println("Clicked: Learn more Link");
		}
		else {
			System.out.println("Not Clicked Learn more Link");
		}
		
		driver.navigate().refresh();
		
		if (driver.getTitle().contains("Creating Account - Docs for Bodt")) {
			System.out.println("Verified Page : Creating Account page.");			
		}
		else
		{
			System.out.println("Not Verified: Creating Account page.");
		}
	
		Thread.sleep(2000);
		driver.quit();
	}	
}

