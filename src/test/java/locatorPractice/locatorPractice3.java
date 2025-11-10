package locatorPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatorPractice3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		/*driver.findElement(By.cssSelector("input[id='newsletter-email']")).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[value='Subscribe']")).click();*/
		/*Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[class='ico-register']")).click();
		driver.findElement(By.cssSelector("input[value='M']")).click();
		driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys("Shubham");
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Das");
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("Pass@123");
		driver.findElement(By.cssSelector("input[name='ConfirmPassword']")).sendKeys("Pass@123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='register-button']")).click();*/
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='apparel']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Digital')]")).click();
		//driver.findElement(By.xpath("//input[contains(@name,'News')]")).sendKeys("abc@gmail.com");
		//WebElement errorMsg=driver.findElement(By.xpath("//span[starts-with(text(),'Login was')]"));
		//System.out.println(errorMsg.getText());
		//driver.findElement(By.xpath("//label[text()='Good']/..//input[@type='radio']")).click();
		//driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']/../..//input[@value='Add to cart']")).click();
		driver.findElement(By.xpath("//input[@value='Search']/preceding-sibling::input")).sendKeys("mobile");
		

	}

}
