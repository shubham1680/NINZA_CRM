package locatorPractice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//id()
		/*driver.findElement(By.id("FirstName")).sendKeys("Shubham");
		driver.findElement(By.id("LastName")).sendKeys("Das");
		driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("Company")).sendKeys("XYZ");*/
		
		//name()
		/*driver.findElement(By.name("username")).sendKeys("shubham123");
		driver.findElement(By.name("password")).sendKeys("pass@123");*/
		
		/*Thread.sleep(2000);
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("gender-male")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FirstName")).sendKeys("Shubham");
		Thread.sleep(2000);
		driver.findElement(By.id("LastName")).sendKeys("Das");
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("def@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("Password")).sendKeys("Pass@123");
		Thread.sleep(2000);
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Pass@123");
		Thread.sleep(2000);
		driver.findElement(By.id("register-button")).click();*/
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		
		
		

	}

}
