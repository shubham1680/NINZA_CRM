package ActionsClassPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionClassPractice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
		
		Actions act=new Actions(driver);
		
		//WebElement drag=driver.findElement(By.id("draggable"));
		//WebElement drop=driver.findElement(By.id("droppable"));
		//Thread.sleep(2000);
		//act.dragAndDrop(drag, drop).perform();
		act.moveToLocation(40, 461).perform();

	}

}
