package testCasePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCasePractice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.findElement(By.linkText("Signup / Login")).click();
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("kjdhdfjdjgdjfjk554456@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Pass@456");
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

	}

}
