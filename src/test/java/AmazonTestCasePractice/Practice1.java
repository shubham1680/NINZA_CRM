package AmazonTestCasePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email_login")).sendKeys("computerworld6290@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		driver.findElement(By.id("ap_phone_number")).sendKeys("6290164634");
		driver.findElement(By.id("ap_customer_name")).sendKeys("Shubham Das");
		driver.findElement(By.id("ap_password")).sendKeys("Pass@123");
		driver.findElement(By.id("continue")).submit();

	}

}
