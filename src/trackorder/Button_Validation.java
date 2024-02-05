package trackorder;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Button_Validation {
	@Test
	public void urlLoad() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.trackorder.app/");
		
		String Url = driver.getCurrentUrl();
	
		if(Url.contains("trackorder"))
		{
			System.out.println("The url is correct: Pass");
		}
		else
		{
			System.out.println("The url is not Fetch: Fail");
		}
	
		WebElement feature = driver.findElement(By.xpath("//h2[text()=' Features ']"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);" , feature);
		
		js.executeAsyncScript("window.scrollBy(0,1900)");
	
	Thread.sleep(5000);
	
	
			
	}

}
	


