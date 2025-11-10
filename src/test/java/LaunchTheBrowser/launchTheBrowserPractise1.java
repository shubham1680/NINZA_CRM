package LaunchTheBrowser;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchTheBrowserPractise1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		
		//driver.manage().window().maximize();
		//Thread.sleep(2000);
		//driver.manage().window().minimize();
		
		//driver.manage().window().fullscreen();
		//Thread.sleep(2000);
		//driver.manage().window().maximize();
		Dimension size=driver.manage().window().getSize();
		System.out.println(size);
		System.out.println(size.getHeight());
		System.out.println(size.getWidth());
		
		//driver.manage().window().setSize(new Dimension(300,300));
		
		Point point=driver.manage().window().getPosition();
		System.out.println(point.getX());
		System.out.println(point.getY());
		
		
		
		

	}

}
