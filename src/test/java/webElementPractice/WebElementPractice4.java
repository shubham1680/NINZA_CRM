package webElementPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementPractice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.google.com/");
		
		System.out.println("Cookies before deleting: "+driver.manage().getCookies().size());
		driver.manage().deleteAllCookies();
		System.out.println("All cookies deleted");
		
		System.out.println("Cookies after deleting: "+driver.manage().getCookies().size());

	}

}
