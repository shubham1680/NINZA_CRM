package SelectClassPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;



public class SelectClassPractice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/books");
		
		WebElement ele = driver.findElement(By.id("products-orderby"));
		Select obj1 = new Select(ele);
		
		//Thread.sleep(2000);
		//obj1.selectByVisibleText("Volvo");
		/*obj1.selectByVisibleText("Saab");
		obj1.selectByVisibleText("Opel");
		obj1.selectByVisibleText("Audi");*/
		
		System.out.println(obj1.isMultiple());
		
		//obj1.deselectAll();
		
		/*Thread.sleep(2000);
		obj1.deselectByVisibleText("Volvo");
		obj1.deselectByVisibleText("Opel");
		obj1.deselectByVisibleText("Audi");*/
		
		
		
		//driver.findElement(By.id("day")).click();
		/*WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		Select obj = new Select(day);
		Select obj1 = new Select(month);
		Select obj2 = new Select(year);
		
		obj.selectByValue("7");
		obj1.selectByValue("4");
		obj2.selectByValue("1998");*/
		
		
		

	}

}
