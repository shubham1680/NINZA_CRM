package testCasePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCasePractice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.findElement(By.linkText("Contact us")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Shubham");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sjdsjdfhefehf534545@gmail.com");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("jddvskvsvskvnjskvnsk");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("skfdkfskdfkdsnfskdfnkjdnf");
		

	}

}
