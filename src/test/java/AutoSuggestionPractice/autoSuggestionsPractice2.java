package AutoSuggestionPractice;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestionsPractice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("mobile");
		
		List<WebElement> mobile=driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']"));
		Thread.sleep(3000);
		for(WebElement ele:mobile)
		{
			System.out.println(ele.getText());
		}

	}

}
