package ActionsClassPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsClassPractice6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		Actions act=new Actions(driver);
		//act.scrollByAmount(0, 800).perform();
		WebElement cart=driver.findElement(By.xpath("//a[text()='Shopping cart']"));
		act.scrollToElement(cart).perform();
	}

}
