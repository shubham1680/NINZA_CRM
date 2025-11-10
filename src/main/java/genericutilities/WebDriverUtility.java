package genericutilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void waitUntilElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void select(WebElement element,int index)
	{
		Select obj=new Select(element);
		obj.selectByIndex(index);
	}
	
	public void select(String value,WebElement element)
	{
		Select obj=new Select(element);
		obj.selectByValue(value);
	}
	
	public void select(WebElement element,String text)
	{
		Select obj=new Select(element);
		obj.selectByVisibleText(text);
	}
	
	public void mouseHoverOnWebElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void clickOnWebElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public void switchDriverControlOnTitle(WebDriver driver,String title)
	{
		String parentId=driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		allId.remove(parentId);
		for(String id:allId)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(title))
				break;
		}
	}
	
	public void switchDriverControlOnURL(WebDriver driver,String URL)
	{
		String parentId=driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		allId.remove(parentId);
		for(String id:allId)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(URL))
				break;
		}
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String switchToAlertAndGetText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	public void switchToAlertAndSendKeys(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element);
	}
	
	public void dragAndDrop(WebDriver driver,WebElement drag,WebElement drop)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
	}
	
	public void clickAndHold(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.clickAndHold(element);
	}
	
	public void release(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.release(element);
	}
	
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.scrollToElement(element);
	}
	
}
