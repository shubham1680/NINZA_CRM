package ActionsClassPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionClassPractice4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://yonobusiness.sbi/yonobusinesslogin");
		
		driver.findElement(By.id("password")).sendKeys("abc");
		WebElement eye1=driver.findElement(By.xpath("//input[@id='password']/..//img[@class='ng-star-inserted']"));
		Actions act=new Actions(driver);
		//act.moveToElement(eye).clickAndHold().perform();
		act.clickAndHold(eye1).perform();
		Thread.sleep(3000);
		//act.release().perform();
		WebElement eye2=driver.findElement(By.xpath("//input[@id='password']/..//img[@class='ng-star-inserted']"));
		act.release(eye2).perform();
	}

}
