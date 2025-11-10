package ActionsClassPractice;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsClassPractice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		
		Actions act = new Actions(driver);
		/*WebElement comp=driver.findElement(By.xpath("//img[@data-testid='img-user-2']"));
		act.moveToElement(comp).perform();*/
		//act.scrollByAmount(0, 850).perform();
		WebElement blog=driver.findElement(By.linkText("Blog"));
		act.scrollToElement(blog).perform();
	
		
		/*driver.findElement(By.id("password")).sendKeys("gbgfgn");
		WebElement eye1=driver.findElement(By.xpath("//input[@id='password']/..//img[@class='ng-star-inserted']"));
		//act.moveToElement(eye).clickAndHold().perform();
		act.clickAndHold(eye1).perform();
		Thread.sleep(3000);
		//act.release().perform();
		WebElement eye2=driver.findElement(By.xpath("//input[@id='password']/..//img[@class='ng-star-inserted']"));
		act.release(eye2).perform();*/
		
		/*WebElement search=driver.findElement(By.id("small-searchterms"));
		//act.sendKeys(search, "mobile").perform();
		act.click(search).keyDown(Keys.SHIFT).sendKeys("mobile").keyUp(Keys.SHIFT).sendKeys(" computer").perform();*/
		
		

	}

}
