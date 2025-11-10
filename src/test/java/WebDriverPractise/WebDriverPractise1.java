package WebDriverPractise;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverPractise1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		
		String parentId=driver.getWindowHandle();
		System.out.println(parentId);
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Facebook")).click();
		
		Set<String> allId=driver.getWindowHandles();
		System.out.println(allId);
		
		for(String window:allId)
		{
			if(!window.equals(parentId))
			{
				driver.switchTo().window(window);
				System.out.println("Switched to:"+driver.getTitle());
			}
		}
		
		Thread.sleep(3000);
		
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());

	}

}
