package SelectClassPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassPractice3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/select-menu");
		
		WebElement car=driver.findElement(By.id("cars"));
		Select obj=new Select(car);
		obj.selectByIndex(0);
		obj.selectByIndex(2);
		obj.selectByIndex(3);
		
		Thread.sleep(3000);
		obj.deselectByValue("volvo");
		obj.deselectByValue("opel");
		obj.deselectByValue("audi");

	}

}
