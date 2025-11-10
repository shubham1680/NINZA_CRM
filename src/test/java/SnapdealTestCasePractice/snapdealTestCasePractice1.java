package SnapdealTestCasePractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class snapdealTestCasePractice1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.snapdeal.com/");
		
		driver.findElement(By.id("inputValEnter")).sendKeys("samsung mobile");
		
		List<WebElement> autosuggest=driver.findElements(By.xpath("//div[@class='suggestionBox topSearch-container']"));
		Thread.sleep(3000);
		for(WebElement ele:autosuggest)
		{
			System.out.println(ele.getText());
		}
		
		driver.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']")).click();
		
		Thread.sleep(3000);
		WebElement scroll=driver.findElement(By.xpath("(//span[@id='display-price-664785540693'])[4]/../../..//p[@class='product-title']"));
		Actions act=new Actions(driver);
		act.scrollToElement(scroll).perform();
		
		driver.findElement(By.xpath("(//span[@id='display-price-664785540693'])[4]/../../..//p[@class='product-title']")).click();
		
		String parentId=driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		for(String win : allId)
		{
			if(!win.equals(parentId))
			{
				driver.switchTo().window(win);
				System.out.println("Switched to child window:"+driver.getTitle());
			}
		}
		
		WebElement addtocart=driver.findElement(By.id("add-cart-button-id"));
		Actions act1=new Actions(driver);
		act1.scrollToElement(addtocart).perform();
		
		driver.findElement(By.id("add-cart-button-id")).click();
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Screenshot/snapdeal.png");
		FileHandler.copy(temp, perm);
		
		

	}

}
