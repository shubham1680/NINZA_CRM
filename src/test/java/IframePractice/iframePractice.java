package IframePractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframePractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/selenium/web/iframes.html");
		driver.switchTo().frame(0);
		
	
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("abc");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("email")).sendKeys("xyz");

	}

}
