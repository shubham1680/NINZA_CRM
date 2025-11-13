package contacttest;

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
import objectrepository.ContactsPage;
import objectrepository.CreateCampaignPage;
import objectrepository.CreateContactPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.SelectCampaignPage;

@Listeners(genericutilities.ListenerImplementation.class)
public class CreateContactTest extends BaseClass{

	@Test(groups = {"smoke","regression"})
	public void CreateContactWithMandatoryFieldsTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		/*PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER=pLib.readDataFromPropertyFile("Browser");
		String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");*/
		
		
		
		ExcelFileUtility eLib=new ExcelFileUtility();
		String CAMPAIGN_NAME=eLib.readDataFromExcelFile("Contacts", 1, 2);
		String TARGET_SIZE=eLib.readDataFromExcelFile("Contacts", 1, 3);
		String ORGANIZATION=eLib.readDataFromExcelFile("Contacts", 1, 4);
		String TITLE=eLib.readDataFromExcelFile("Contacts", 1, 5);
		String CONTACT_NAME=eLib.readDataFromExcelFile("Contacts", 1, 6);
		String SELECT_CAMPAIGN_PAGE_TITLE = eLib.readDataFromExcelFile("Contacts", 1, 8);
		String CAMPAIGN_DD_VALUE = eLib.readDataFromExcelFile("Contacts", 1, 9);
		String TOAST_MSG_VERIFICATION = eLib.readDataFromExcelFile("Contacts", 1, 10);
		
		JavaUtility jLib=new JavaUtility();
		
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

		wLib.implicitWait(driver);
	
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);*/
		
	
		CampaignsPage campaignsPage=new CampaignsPage(driver);
		Thread.sleep(2000);
		campaignsPage.getAddCreateCampaignBtn().click();
		CreateCampaignPage createCampaignPage=new CreateCampaignPage(driver);
		createCampaignPage.getCampaignNameTF().sendKeys(CAMPAIGN_NAME);
	
		createCampaignPage.getTargetSizeTF().clear();
		createCampaignPage.getTargetSizeTF().sendKeys(TARGET_SIZE);
		Thread.sleep(2000);
		createCampaignPage.getCreateCampaignBtn().click();
		
		HomePage homePage=new HomePage(driver);
		homePage.getCloseToastMsg().click();
		
		
		
		homePage.getContactsLink().click();
		
		
		ContactsPage contactsPage=new ContactsPage(driver);
		contactsPage.getCreateContactBtn().click();
		
		CreateContactPage createContactPage=new CreateContactPage(driver);
		createContactPage.getOrganizationNameTF().sendKeys(ORGANIZATION);
		
		createContactPage.getTitleTF().sendKeys(TITLE);
		
		createContactPage.getContactNameTF().sendKeys(CONTACT_NAME);
		
		createContactPage.getMobileTF().sendKeys("9"+jLib.generateNineDigitNumber());
		
		createContactPage.getPlusBtn().click();
	
		
	
		
		String parentId=driver.getWindowHandle();
		wLib.switchDriverControlOnTitle(driver, SELECT_CAMPAIGN_PAGE_TITLE);
		
		SelectCampaignPage selectCampaignPage=new SelectCampaignPage(driver);
		WebElement campaignDD=selectCampaignPage.getCampaignDD();
	
		wLib.select(CAMPAIGN_DD_VALUE, campaignDD);
		

		selectCampaignPage.getSearchTF().sendKeys(CAMPAIGN_NAME);
		
		selectCampaignPage.getSelectBtn().click();
		
		driver.switchTo().window(parentId);
		
		createContactPage.getCreateContactBtn().click();
		
		
	
		
		WebElement toastMsg=homePage.getToastMsg();
		
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		String msg=toastMsg.getText();
		/*if(msg.contains(TOAST_MSG_VERIFICATION))
			System.out.println("Contact created");
		else
			System.out.println("Contact not created");*/
		
		homePage.getCloseToastMsg().click();
		Assert.assertTrue(msg.contains(TOAST_MSG_VERIFICATION));
		
	
		//homePage.logout();
		
		//driver.quit();

	}
}
