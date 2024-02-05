package Bodt.io;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class verifyTitle {
	public void validateTitle() throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https:bodt.io");
		
		String title = driver.getTitle();
		
		System.out.println(title);

		if(title.contains("Bodt") || title.contains("bodt"))
		{
			System.out.println("Verify: The Title is Find");
		}
		else
			System.out.println("Not Verify: The Title is not Find");
		
		Thread.sleep(5000);
		driver.quit();
	
	}

}
