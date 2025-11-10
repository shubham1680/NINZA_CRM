package testCasePractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCasePractice5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://automationexercise.com");
		
		driver.findElement(By.partialLinkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='/get_product_picture/1']/../../..//a[text()='View Product']")).click();

	}

}
