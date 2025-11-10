package SwitchToPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchToWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Facebook")).click();
		
		String parentId=driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		for(String window : allId)
		{
			if(!window.equals(parentId))
			{
				driver.switchTo().window(window);
				System.out.println("Switched to child window:"+driver.getTitle());
			}
		}

	}

}
