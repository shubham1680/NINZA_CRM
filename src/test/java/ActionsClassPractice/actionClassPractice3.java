package ActionsClassPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionClassPractice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
		
		/*Actions act=new Actions(driver);
		WebElement hover=driver.findElement(By.id("hover"));
		act.moveToElement(hover).perform();*/
		
		Actions act=new Actions(driver);
		WebElement comp=driver.findElement(By.id("clickable"));
		act.contextClick(comp).perform();

	}

}
