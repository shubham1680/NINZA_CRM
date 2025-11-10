package WebDriverPractise;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverPractise2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String title=driver.getTitle();
		System.out.println(title);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		//String source=driver.getPageSource();
		//System.out.println(source);
		
		//driver.findElement(By.linkText("Looking for templates?")).click();
		//Thread.sleep(3000);
		//driver.close();
		//driver.quit();
		
		//driver.navigate().to("https://webflow.com/made-in-webflow/demo");
		//driver.navigate().to(new URL("https://webflow.com/made-in-webflow/demo"));
		/*driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();*/
		
		String parentId=driver.getWindowHandle();
		System.out.println(parentId);
		Set<String> allId=driver.getWindowHandles();
		System.out.println(allId);
		
	
		

	}

}
