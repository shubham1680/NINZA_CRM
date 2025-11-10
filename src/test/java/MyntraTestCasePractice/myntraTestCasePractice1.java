package MyntraTestCasePractice;

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

public class myntraTestCasePractice1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("mens shirt");
		
		List<WebElement> autosuggest=driver.findElements(By.xpath("//div[@class=' desktop-autoSuggest desktop-showContent']"));
		Thread.sleep(3000);
		for(WebElement ele:autosuggest)
		{
			System.out.println(ele.getText());
		}
		
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
		
		driver.findElement(By.xpath("(//button[@class='size-buttons-size-button size-buttons-size-button-default'])[4]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-bag')]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
		
		Thread.sleep(3000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Screenshot/myntra.png");
		FileHandler.copy(temp, perm);
		

	}

}
