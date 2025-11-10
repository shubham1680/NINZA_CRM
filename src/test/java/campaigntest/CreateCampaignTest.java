package campaigntest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtility;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtility;
import objectrepository.CampaignsPage;
import objectrepository.CreateCampaignPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;

@Listeners(genericutilities.ListenerImplementation.class)
public class CreateCampaignTest extends BaseClass{

	@Test(groups = {"smoke","regression"})
	public void createCampaignWithMandatoryFieldsTest() throws EncryptedDocumentException, IOException
	{
		/*PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER=pLib.readDataFromPropertyFile("Browser");
		String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");*/
		
		ExcelFileUtility eLib=new ExcelFileUtility();
		String CAMPAIGN_NAME=eLib.readDataFromExcelFile("Campaign", 1, 2);
		String TARGET_SIZE=eLib.readDataFromExcelFile("Campaign", 1, 3);
		String TOAST_MSG_VERIFICATION=eLib.readDataFromExcelFile("Campaign", 1, 4);
		
		/*ChromeOptions options=new ChromeOptions();
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
		
		wLib.implicitWait(driver);*/
		
		
		/*LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);*/
		
	
		CampaignsPage campaignsPage=new CampaignsPage(driver);
		campaignsPage.getAddCreateCampaignBtn().click();
		CreateCampaignPage createCampaignPage=new CreateCampaignPage(driver);
		createCampaignPage.getCampaignNameTF().sendKeys(CAMPAIGN_NAME);
		
		createCampaignPage.getTargetSizeTF().clear();
		createCampaignPage.getTargetSizeTF().sendKeys(TARGET_SIZE);
		
		createCampaignPage.getCreateCampaignBtn().click();
		
		HomePage homePage=new HomePage(driver);
		
		WebElement toastMsg=homePage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		String msg=toastMsg.getText();
		/*if(msg.contains(TOAST_MSG_VERIFICATION))
			System.out.println("Campaign created");
		else
			System.out.println("Campaign not created");*/
		homePage.getCloseToastMsg().click();
		Assert.assertTrue(msg.contains(TOAST_MSG_VERIFICATION));
		System.out.println("hello");
		System.out.println("Hello");
		
	
		//homePage.logout();
		
		//driver.quit();
	}
	
	@Test(groups = "smoke")
	public void createCampaignWithStatusTest() throws EncryptedDocumentException, IOException
	{
		/*PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER=pLib.readDataFromPropertyFile("Browser");
		String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");*/
		
		ExcelFileUtility eLib=new ExcelFileUtility();
		String CAMPAIGN_NAME=eLib.readDataFromExcelFile("Campaign", 4, 2);
		String TARGET_SIZE=eLib.readDataFromExcelFile("Campaign", 4, 3);
		String CAMPAIGN_STATUS=eLib.readDataFromExcelFile("Campaign", 4, 4);
		String TOAST_MSG_VERIFICATION=eLib.readDataFromExcelFile("Campaign", 4, 5);
		
		/*ChromeOptions options=new ChromeOptions();
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
		
		wLib.implicitWait(driver);*/
		
		/*LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);*/
		

		CampaignsPage campaignsPage=new CampaignsPage(driver);
		campaignsPage.getAddCreateCampaignBtn().click();
		CreateCampaignPage createCampaignPage=new CreateCampaignPage(driver);
		createCampaignPage.getCampaignNameTF().sendKeys(CAMPAIGN_NAME);
	
		createCampaignPage.getCampaignStatusTF().sendKeys(CAMPAIGN_STATUS);
	
		createCampaignPage.getTargetSizeTF().clear();
		createCampaignPage.getTargetSizeTF().sendKeys(TARGET_SIZE);
		
		createCampaignPage.getCreateCampaignBtn().click();
		
		HomePage homePage=new HomePage(driver);

		WebElement toastMsg=homePage.getToastMsg();
	
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		String msg=toastMsg.getText();
		/*if(msg.contains(TOAST_MSG_VERIFICATION))
			System.out.println("Campaign created");
		else
			System.out.println("Campaign not created");*/
		
		homePage.getCloseToastMsg().click();
		Assert.assertTrue(msg.contains(TOAST_MSG_VERIFICATION));
		
		
		//homePage.logout();
		
		//driver.quit();
	}
	
	@Test(groups = "regression")
	public void createCampaignWithExpectedCloseDateTest() throws EncryptedDocumentException, IOException
	{
		/*PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER=pLib.readDataFromPropertyFile("Browser");
		String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");*/
		
		//Generate date after 30 days
		JavaUtility jLib=new JavaUtility();
		String date=jLib.getRequiredDate(50);
		
		ExcelFileUtility eLib=new ExcelFileUtility();
		String CAMPAIGN_NAME=eLib.readDataFromExcelFile("Campaign", 7, 2);
		String TARGET_SIZE=eLib.readDataFromExcelFile("Campaign", 7, 3);
		String TOAST_MSG_VERIFICATION=eLib.readDataFromExcelFile("Campaign", 7, 4);
		
		/*ChromeOptions options=new ChromeOptions();
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
	
		wLib.implicitWait(driver);*/
		
		
		/*LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);*/
		
		
		
		CampaignsPage campaignsPage=new CampaignsPage(driver);
		campaignsPage.getAddCreateCampaignBtn().click();
		CreateCampaignPage createCampaignPage=new CreateCampaignPage(driver);
		createCampaignPage.getCampaignNameTF().sendKeys(CAMPAIGN_NAME);
		
		createCampaignPage.getExpectedCloseDateTF().sendKeys(date);

		createCampaignPage.getTargetSizeTF().clear();
		createCampaignPage.getTargetSizeTF().sendKeys(TARGET_SIZE);
	
		createCampaignPage.getCreateCampaignBtn().click();
		HomePage homePage=new HomePage(driver);
		
		WebElement toastMsg=homePage.getToastMsg();
		
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		String msg=toastMsg.getText();
		/*if(msg.contains(TOAST_MSG_VERIFICATION))
			System.out.println("Campaign created");
		else
			System.out.println("Campaign not created");*/
		
		homePage.getCloseToastMsg().click();
		Assert.assertTrue(msg.contains(TOAST_MSG_VERIFICATION));
		
	
		//homePage.logout();
		
		//driver.quit();
	}
}
