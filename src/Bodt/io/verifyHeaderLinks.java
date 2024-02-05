package Bodt.io;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class verifyHeaderLinks {
	@Test
	public void VerifyHeaderLink() throws InterruptedException
	{
		// print status.
		System.out.println("Hello Bodt.io");
		//Launch CHROME Browser
		WebDriver driver= new ChromeDriver();
		//Maximize Browser
		driver.manage().window().maximize();
		//Wait until the URl is load and Element to be loaded. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Launch URL on Google.
		driver.get("https:bodt.io");
		String currentTab = driver.getWindowHandle();
		
		//wait for  2 second.
		Thread.sleep(2000);
		
		// Header Links:
		List<WebElement> headerLink = driver.findElements(By.xpath("//div[@class=\"hidden lg:flex lg:gap-x-12\"]/child::a"));
		//Multiple Action Method to do in script that perform.
		Actions action= new Actions(driver);
		
        //Fetch all the links from this for each loop:
		for(WebElement allLinks:headerLink)
		{
		    //click on every links:
			action.keyDown(Keys.CONTROL).click(allLinks).perform();
			action.keyUp(Keys.CONTROL).perform();
		}
		
		Thread.sleep(5000);
		//Here will go every tab through the tab id.
		ArrayList<String> allTab = new ArrayList<String>(driver.getWindowHandles());
		for(int i=1;i<allTab.size();i++)
		{
			driver.switchTo().window(allTab.get(i));
			
			System.out.println("The Title of Header Links: "+driver.getTitle());
			driver.close();
		}
		Thread.sleep(3000);
		driver.switchTo().window(currentTab);
		
		Thread.sleep(1000);
		WebElement pricingView = driver.findElement(By.xpath("//a[text()='View Full Pricing']"));
		
		action.moveToElement(pricingView).perform();
		
		Thread.sleep(3000);
		driver.quit();
		
		}
}
