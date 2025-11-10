package testCasePractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCasePractice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		driver.findElement(By.linkText("Signup / Login")).click();
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sjdsjdfhefehf534545@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Pass@654");
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
		

	}

}
