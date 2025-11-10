package DataDrivenTestingPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class CreateContactWithMandatoryFieldsTest {

	public static void main(String[] args) throws IOException {
		/*FileInputStream fis=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\Commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String BROWSER=prop.getProperty("Browser");
		String URL=prop.getProperty("URL");
		String USERNAME=prop.getProperty("Username");
		String PASSWORD=prop.getProperty("Password");*/
		PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER=pLib.readDataFromPropertyFile("Browser");
		String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");
		
		/*FileInputStream fis1=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\NINJACrm.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String CAMPAIGN_NAME=wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		String TARGET_SIZE=wb.getSheet("Contacts").getRow(1).getCell(3).getStringCellValue();
		String ORGANIZATION = wb.getSheet("Contacts").getRow(1).getCell(4).getStringCellValue();
		String TITLE=wb.getSheet("Contacts").getRow(1).getCell(5).getStringCellValue();
		String CONTACT_NAME=wb.getSheet("Contacts").getRow(1).getCell(6).getStringCellValue();
		String MOBILE=wb.getSheet("Contacts").getRow(1).getCell(7).getStringCellValue();
		wb.close();*/
		
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
		createCampaignPage.getTargetSizeTF().clear();
		createCampaignPage.getTargetSizeTF().sendKeys(TARGET_SIZE);
		//WebElement targetSize=driver.findElement(By.name("targetSize"));
		//targetSize.clear();
		//targetSize.sendKeys(TARGET_SIZE);
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		createCampaignPage.getCreateCampaignBtn().click();
		//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		HomePage homePage=new HomePage(driver);
		homePage.getCloseToastMsg().click();
		
		//driver.findElement(By.linkText("Contacts")).click();
		
		homePage.getContactsLink().click();
		
		//driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		ContactsPage contactsPage=new ContactsPage(driver);
		contactsPage.getCreateContactBtn().click();
		
		CreateContactPage createContactPage=new CreateContactPage(driver);
		createContactPage.getOrganizationNameTF().sendKeys(ORGANIZATION);
		//driver.findElement(By.name("organizationName")).sendKeys(ORGANIZATION);
		createContactPage.getTitleTF().sendKeys(TITLE);
		//driver.findElement(By.name("title")).sendKeys(TITLE);
		createContactPage.getContactNameTF().sendKeys(CONTACT_NAME);
		//driver.findElement(By.name("contactName")).sendKeys(CONTACT_NAME);
		createContactPage.getMobileTF().sendKeys("9"+jLib.generateNineDigitNumber());
		//driver.findElement(By.name("mobile")).sendKeys("9"+jLib.generateNineDigitNumber());
		createContactPage.getPlusBtn().click();
		//driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
		
		/*String parentId=driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		allId.remove(parentId);
		for(String id:allId)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains("Select Campaign"))
				break;
		}*/
		
		String parentId=driver.getWindowHandle();
		wLib.switchDriverControlOnTitle(driver, SELECT_CAMPAIGN_PAGE_TITLE);
		
		SelectCampaignPage selectCampaignPage=new SelectCampaignPage(driver);
		WebElement campaignDD=selectCampaignPage.getCampaignDD();
		//WebElement campaignDD=driver.findElement(By.id("search-criteria"));
		//Select obj=new Select(campaignDD);
		//obj.selectByValue("campaignName");
		wLib.select(CAMPAIGN_DD_VALUE, campaignDD);
		
		//driver.findElement(By.id("search-input")).sendKeys(CAMPAIGN_NAME);
		selectCampaignPage.getSearchTF().sendKeys(CAMPAIGN_NAME);
		//driver.findElement(By.xpath("//button[@class='select-btn']")).click();
		selectCampaignPage.getSelectBtn().click();
		
		driver.switchTo().window(parentId);
		
		createContactPage.getCreateContactBtn().click();
		//driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
	
		//WebElement toastMsg=driver.findElement(By.xpath("//div[@role='alert']"));
		WebElement toastMsg=homePage.getToastMsg();
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(toastMsg));
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		String msg=toastMsg.getText();
		if(msg.contains(TOAST_MSG_VERIFICATION))
			System.out.println("Contact created");
		else
			System.out.println("Contact not created");
		//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		homePage.getCloseToastMsg().click();
		
		/*WebElement userIcon=driver.findElement(By.xpath("//div[@class='user-icon']"));
		//Actions act=new Actions(driver);
		//act.moveToElement(userIcon).perform();
		wLib.mouseHoverOnWebElement(driver, userIcon);
		WebElement logoutBtn=driver.findElement(By.xpath("//div[text()='Logout ']"));
		//act.moveToElement(logoutBtn).click().perform();
		wLib.clickOnWebElement(driver, logoutBtn);*/
		homePage.logout();
		
		driver.quit();

	}

}
