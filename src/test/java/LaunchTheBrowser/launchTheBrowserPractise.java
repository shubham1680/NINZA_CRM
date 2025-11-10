package LaunchTheBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

//import org.openqa.selenium.chrome.ChromeDriver;

public class launchTheBrowserPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//ChromeDriver driver=new ChromeDriver();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		String title=driver.getTitle();
		System.out.println(title);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String source=driver.getPageSource();
		System.out.println(source);
		driver.findElement(By.linkText("Facebook")).click();
		Thread.sleep(3000);
		//driver.close();
		//driver.quit();
		

	}

}
