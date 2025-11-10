package LaunchTheBrowser;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class LaunchTheBrowserPractice3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		//driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("input"));
		System.out.println(links.size());
		/*Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();*/
		
		
		/*Dimension size = driver.manage().window().getSize();
		System.out.println(size);*/
		//driver.manage().window().setSize(new Dimension(300,300));
		//Dimension size = driver.manage().window().getSize();
		//System.out.println(size);
		/*Point point = driver.manage().window().getPosition();
		System.out.println(point);
		System.out.println(point.getX());
		System.out.println(point.getY());*/
		//Thread.sleep(2000);
		//driver.manage().window().setPosition(new Point(10,10));
		
		
		/*driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		//String id = driver.getWindowHandle();
		//System.out.println(id);
		/*Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Become")).click();
		
		Set<String> allIds = driver.getWindowHandles();
		System.out.println(allIds);
		/*String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		//String source = driver.getPageSource();
		//System.out.println(source);
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Become")).click();
		Thread.sleep(3000);*/
		//driver.close();
		//driver.quit();
		
		

	}

}
