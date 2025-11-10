package IframePractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframePractice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/dshub/OneDrive/Documents/iframes.html");
		driver.switchTo().frame("FR1");
		Thread.sleep(2000);
		driver.findElement(By.id("small-searchterms")).sendKeys("mobile");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("FR2");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Book a Demo']")).click();
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
	}

}
