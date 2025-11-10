package JavascriptExecutorPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class javaScriptExecutorPractice5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("mens shirt");
		driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
		Thread.sleep(3000);
		WebElement shirt=driver.findElement(By.xpath("(//h3[text()='HERE&NOW'])[1]/../..//span[@class='product-discountedPrice']"));
		Actions act=new Actions(driver);
		act.scrollToElement(shirt).perform();
		
		driver.findElement(By.xpath("(//h3[text()='HERE&NOW'])[1]/../..//span[@class='product-discountedPrice']")).click();
		

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
		
		WebElement addtobag=driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-bag')]"));
		Actions act1=new Actions(driver);
		act1.scrollToElement(addtobag).perform();
		
		WebElement disable=driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-bag')]"));
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", disable);

	}

}
