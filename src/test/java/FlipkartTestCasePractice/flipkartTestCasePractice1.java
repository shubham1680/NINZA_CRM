package FlipkartTestCasePractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class flipkartTestCasePractice1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("mobile");
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		
		WebElement mobile=driver.findElement(By.xpath("(//img[@class='DByuf4'])[3]"));
		Actions act=new Actions(driver);
		act.scrollToElement(mobile).perform();
		
		driver.findElement(By.xpath("(//img[@class='DByuf4'])[3]")).click();
		
		String parentId=driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		Thread.sleep(3000);
		for(String window:allId)
		{
			if(!window.equals(parentId))
			{
				driver.switchTo().window(window);
				System.out.println("Switched to child window:"+driver.getTitle());
			}
		}
		
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
		
		Thread.sleep(3000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Screenshot/flipkart.png");
		FileHandler.copy(temp, perm);

	}

}
