package locatorPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice1 {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		
		//driver.findElement(By.id("topcartlink")).click();
		
		//driver.findElement(By.name("NewsletterEmail")).sendKeys("abc@gmail.com");
		
		//driver.findElement(By.linkText("Log in")).click();
		//driver.findElement(By.className("email")).sendKeys("abc@gmail.com");
		
		//driver.findElement(By.partialLinkText("Apparel")).click();
	}

}
