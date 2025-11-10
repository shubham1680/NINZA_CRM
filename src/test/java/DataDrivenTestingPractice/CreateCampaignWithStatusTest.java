package DataDrivenTestingPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericutilities.ExcelFileUtility;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtility;
import objectrepository.CampaignsPage;
import objectrepository.CreateCampaignPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;

public class CreateCampaignWithStatusTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER=pLib.readDataFromPropertyFile("Browser");
		String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");
		
		ExcelFileUtility eLib=new ExcelFileUtility();
		String CAMPAIGN_NAME=eLib.readDataFromExcelFile("Campaign", 4, 2);
		String TARGET_SIZE=eLib.readDataFromExcelFile("Campaign", 4, 3);
		String CAMPAIGN_STATUS=eLib.readDataFromExcelFile("Campaign", 4, 4);
		String TOAST_MSG_VERIFICATION=eLib.readDataFromExcelFile("Campaign", 4, 5);
		
		ChromeOptions options=new ChromeOptions();
		Map<String,Object> prefs=new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--guest");
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver(options);
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(BROWSER.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else if(BROWSER.equalsIgnoreCase("safari"))
			driver=new SafariDriver();
		
		WebDriverUtility wLib=new WebDriverUtility();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wLib.implicitWait(driver);
		/*driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();*/
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);
		
		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		CampaignsPage campaignsPage=new CampaignsPage(driver);
		campaignsPage.getAddCreateCampaignBtn().click();
		CreateCampaignPage createCampaignPage=new CreateCampaignPage(driver);
		createCampaignPage.getCampaignNameTF().sendKeys(CAMPAIGN_NAME);
		//driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGN_NAME);
		//driver.findElement(By.name("campaignStatus")).sendKeys(CAMPAIGN_STATUS);
		createCampaignPage.getCampaignStatusTF().sendKeys(CAMPAIGN_STATUS);
		//WebElement targetSize=driver.findElement(By.name("targetSize"));
		//targetSize.clear();
		//targetSize.sendKeys(TARGET_SIZE);
		createCampaignPage.getTargetSizeTF().clear();
		createCampaignPage.getTargetSizeTF().sendKeys(TARGET_SIZE);
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		createCampaignPage.getCreateCampaignBtn().click();
		
		HomePage homePage=new HomePage(driver);
		//WebElement toastMsg=driver.findElement(By.xpath("//div[@role='alert']"));
		WebElement toastMsg=homePage.getToastMsg();
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(toastMsg));
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		String msg=toastMsg.getText();
		if(msg.contains(TOAST_MSG_VERIFICATION))
			System.out.println("Campaign created");
		else
			System.out.println("Campaign not created");
		//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		homePage.getCloseToastMsg().click();
		
		/*WebElement userIcon=driver.findElement(By.xpath("//div[@class='user-icon']"));
		//Actions act=new Actions(driver);
		//act.moveToElement(userIcon).perform();
		wLib.mouseHoverOnWebElement(driver, userIcon);
		WebElement logoutBtn=driver.findElement(By.xpath("//div[text()='Logout ']"));
		wLib.clickOnWebElement(driver, logoutBtn);*/
		homePage.logout();
		
		driver.quit();
		
		
		

	}

}
