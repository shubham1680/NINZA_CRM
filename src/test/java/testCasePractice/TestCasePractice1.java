package testCasePractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCasePractice1 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stu
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://automationexercise.com");
		driver.findElement(By.partialLinkText("Signup / Login")).click();
		driver.findElement(By.name("name")).sendKeys("Shubham");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("dfjsdfjdfs@gmail.com");
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).submit();
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys("Pass@987");
		WebElement day=driver.findElement(By.id("days"));
		WebElement month=driver.findElement(By.id("months"));
		WebElement year=driver.findElement(By.id("years"));
		
		Select sc1=new Select(day);
		Select sc2=new Select(month);
		Select sc3=new Select(year);
		
		sc1.selectByValue("12");
		sc2.selectByVisibleText("December");
		sc3.selectByValue("1998");
		
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("first_name")).sendKeys("Shubham");
		driver.findElement(By.id("last_name")).sendKeys("Das");
		driver.findElement(By.id("company")).sendKeys("XYZ");
		driver.findElement(By.id("address1")).sendKeys("Bagati");
		driver.findElement(By.id("address2")).sendKeys("Mogra");
		
		WebElement country=driver.findElement(By.id("country"));
		Select sc4=new Select(country);
		sc4.selectByVisibleText("Australia");
		
		driver.findElement(By.id("state")).sendKeys("West Bengal");
		driver.findElement(By.id("city")).sendKeys("Mogra");
		driver.findElement(By.id("zipcode")).sendKeys("712148");
		driver.findElement(By.id("mobile_number")).sendKeys("6290164634");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
	}

}
