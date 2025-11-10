package AmazonTestCasePractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class practice2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
		Thread.sleep(3000);
		
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='left-pane-results-container']"));
		for(WebElement element:ele)
		{
			System.out.println(element.getText());
		}
		
		driver.findElement(By.id("nav-search-submit-button")).submit();
		
		Actions act=new Actions(driver);
		WebElement laptop=driver.findElement(By.xpath("//span[text()='55,990']/../../../../../../..//button[@id='a-autoid-1-announce']"));
		act.scrollToElement(laptop).perform();
		
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		
	    String parentId=driver.getWindowHandle();
	    Set<String> allId=driver.getWindowHandles();
	    Thread.sleep(3000);
	    for(String win:allId)
	    {
	    	if(!win.equals(parentId))
	    	{
	    		driver.switchTo().window(win);
	    		System.out.println("Switched to child window:"+driver.getTitle());
	    	}
	    }
	    
	    WebElement addtocart=driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
	    Actions act1=new Actions(driver);
	    act1.scrollToElement(addtocart).perform();
	    
	    driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		
		Thread.sleep(3000);
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Screenshot/product.png");
		FileHandler.copy(temp, perm);

	}

}
