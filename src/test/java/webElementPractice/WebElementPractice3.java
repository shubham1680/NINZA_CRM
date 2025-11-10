package webElementPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementPractice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		//driver.findElement(By.id("small-searchterms")).sendKeys("mobile");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.findElement(By.partialLinkText("Books")).click();
		//driver.findElement(By.linkText("Register")).click();
		/*driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		//Check element present in DOM
		List<WebElement> elements=driver.findElements(By.id("Email"));
		if(elements.size()>0)
		{
			System.out.println("Element present in DOM");
		}
		else
			System.out.println("Element not found");
		
		//Check element visible on GUI
		WebElement element=driver.findElement(By.id("Email"));
		if(element.isDisplayed())
			System.out.println("Element is visible on GUI");
		else
			System.out.println("Element is not visible");
		
		//Check if interactable
		if(element.isEnabled())
			System.out.println("Element is enabled");
		else
			System.out.println("Element is not enabled");
		
		//For element present dynamic webpages to wait until the element is visible
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
		if(ele.isDisplayed())
			System.out.println("Element is visible on GUI");
		else
			System.out.println("Element is not visible");*/
		
		//Check the text from UI
		/*WebElement ele=driver.findElement(By.linkText("Register"));
		String text=ele.getText();
		System.out.println("Text from UI: "+text);
		
		driver.findElement(By.id("small-searchterms")).sendKeys("mobile");
		WebElement inputBox=driver.findElement(By.id("small-searchterms"));
		String enteredText=inputBox.getAttribute("value");
		System.out.println("Entered text:"+enteredText);*/
		
		//check object is selected or not
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("gender-male")).click();
		WebElement ele=driver.findElement(By.id("gender-male"));
		if(ele.isSelected())
			System.out.println("Radio button selected");
		else
			System.out.println("Button is not selected");
	}

}
