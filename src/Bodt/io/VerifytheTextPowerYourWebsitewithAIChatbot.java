package Bodt.io;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifytheTextPowerYourWebsitewithAIChatbot {
	
	
		@Test
		public void VerifyTextVisible() throws InterruptedException
		
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
			WebElement text = driver.findElement(By.xpath("//span[text()='AI-Chatbot']/parent::h1"));
			System.out.println(text.getText());
			
			if(text.getAccessibleName().contains("Power Your Website"))
			{
				System.out.println("Verified: The text is True.");
			}
			else
				System.out.println("Not Verified: The text is False.");
			
			Thread.sleep(2000);
			driver.quit();
		
	}
}
