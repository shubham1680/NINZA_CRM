package SauceDemoPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SauceDemoPractice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).submit();
		
		Thread.sleep(3000);
		WebElement product=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select obj=new Select(product);
		obj.selectByValue("lohi");
		
		//driver.findElement(By.id("react-burger-menu-btn")).click();
		/*Thread.sleep(3000);
		//driver.findElement(By.id("logout_sidebar_link")).click();
		driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/../../../..//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/../../../..//button[@id='remove-sauce-labs-bike-light']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Shubham");
		driver.findElement(By.id("last-name")).sendKeys("Das");
		driver.findElement(By.id("postal-code")).sendKeys("712148");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.id("back-to-products")).click();*/

	}

}
