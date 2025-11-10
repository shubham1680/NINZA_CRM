package PopupsPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.easemytrip.com/");
		driver.findElement(By.id("ddate")).click();
		
		while(true)
		{
			String monthYear=driver.findElement(By.xpath("//div[@class='month2']")).getText();
			if(monthYear.equals("December 2025"))
			{
				break;
			}
			driver.findElement(By.id("img2Nex")).click();
		}

	}

}
