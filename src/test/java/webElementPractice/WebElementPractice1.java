package webElementPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementPractice1 {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Facebook")).click();
		driver.findElement(By.linkText("Twitter")).click();
		driver.findElement(By.linkText("YouTube")).click();
		
		//boolean displayed = driver.findElement(By.id("email")).isDisplayed();
		//System.out.println(displayed);
		String parent=driver.getWindowHandle();
		
		Set<String> all=driver.getWindowHandles();
		for(String window : all)
		{
			if(!window.equals(parent))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		System.out.println("Child window:"+driver.getTitle());
		
		/*driver.switchTo().window(parent);
		System.out.println("Parent window:"+driver.getTitle());*/
		
		
		
		
		/*driver.findElement(By.name("username")).sendKeys("Shubham");
		driver.findElement(By.name("password")).sendKeys("5445463455344");
		WebElement check = driver.findElement(By.xpath("//button[@type='submit']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(check));
		
		check.click();*/
		
		//WebDriverWait wait = new WebDriverWait(driver,)
		
		/*WebElement ele = driver.findElement(By.xpath("//option[@value='https://demowebshop.tricentis.com/books?pagesize=4']"));
		//Thread.sleep(2000);
		//System.out.println(ele.isSelected());
		Thread.sleep(2000);
		ele.click();
		System.out.println("After selecting");
		Thread.sleep(2000);
		System.out.println(ele.isEnabled());*/
		/*Point point = driver.findElement(By.xpath("//button[@type='submit']")).getLocation();
		System.out.println(point);
		System.out.println(point.getX());
		System.out.println(point.getY());*/
		/*driver.findElement(By.id("small-searchterms")).sendKeys("mobile");
		Thread.sleep(3000);
		driver.findElement(By.id("small-searchterms")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
		driver.findElement(By.xpath("//input[@value='Search']")).click();*/
		
		/*driver.findElement(By.partialLinkText("Books")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Computing and Internet']/../..//input[@class='button-2 product-box-add-to-cart-button']")).click();
		Thread.sleep(2000);
		String text= driver.findElement(By.className("content")).getText();
		System.out.println(text);*/
		
		/*String text=driver.findElement(By.id("small-searchterms")).getAttribute("class");
		System.out.println(text);
		
		String tagName=driver.findElement(By.id("small-searchterms")).getTagName();
		System.out.println(tagName);*/
		//Thread.sleep(2000);
		/*WebElement ele=driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println(ele.isEnabled());
		driver.findElement(By.name("username")).sendKeys("hssjs");
		driver.findElement(By.name("password")).sendKeys("5456565454");
		
		System.out.println(ele.isEnabled());*/
		

	}

}
