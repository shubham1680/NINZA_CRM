package POMPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "username")
	private WebElement usernameTF;
	
	@FindBy(id = "inputPassword")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInBtn;
	
	public void setUsername(String username)
	{
		usernameTF.sendKeys(username);
	}
	public void setPassword(String password)
	{
		passwordTF.sendKeys(password);
	}
	public void clickSignIn()
	{
		signInBtn.click();
	}
	
	
}
