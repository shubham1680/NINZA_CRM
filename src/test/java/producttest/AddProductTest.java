package producttest;

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
import objectrepository.AddProductPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.ProductsPage;

@Listeners(genericutilities.ListenerImplementation.class)
public class AddProductTest extends BaseClass {

	@Test(groups = {"smoke","regression"})
	public void addProductMobile() throws EncryptedDocumentException, IOException
	{
		/*PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER=pLib.readDataFromPropertyFile("Browser");
		String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");*/
		
		ExcelFileUtility eLib=new ExcelFileUtility();
		String PRODUCT_NAME = eLib.readDataFromExcelFile("Products", 1, 1);
		String CATEGORY_DD = eLib.readDataFromExcelFile("Products", 1, 2);
		String QUANTITY = eLib.readDataFromExcelFile("Products", 1, 3);
		String PRICE = eLib.readDataFromExcelFile("Products", 1, 4);
		String VENDOR_ID_DD = eLib.readDataFromExcelFile("Products", 1, 5);
		String TOAST_MSG_VERIFICATION = eLib.readDataFromExcelFile("Products", 1, 6);
		
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
		
		driver.manage().window().maximize();
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.implicitWait(driver);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);*/
		
		HomePage homePage=new HomePage(driver);
		homePage.getProductsLink().click();
		
		ProductsPage productsPage=new ProductsPage(driver);
		productsPage.getAddProductBtn().click();
		
		AddProductPage addProductPage=new AddProductPage(driver);
		JavaUtility jLib=new JavaUtility();
		addProductPage.getProductNameTF().sendKeys(PRODUCT_NAME+jLib.generateRandomNumber());
		
		WebElement CategoryDD = addProductPage.getSelectCategoryDD();
		wLib.select(CategoryDD, CATEGORY_DD);
		
		addProductPage.getQuantityTF().clear();
		addProductPage.getQuantityTF().sendKeys(QUANTITY);
		
		addProductPage.getPriceTF().clear();
		addProductPage.getPriceTF().sendKeys(PRICE);
		
		WebElement VendorDD = addProductPage.getSelectVendorDD();
		wLib.select(VendorDD,VENDOR_ID_DD);
		
		addProductPage.getAddBtn().click();
		
		WebElement toastMsg=homePage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		String msg=toastMsg.getText();
		/*if(msg.contains(TOAST_MSG_VERIFICATION))
			System.out.println("Product added");
		else
			System.out.println("Product not added");*/
		homePage.getCloseToastMsg().click();
		Assert.assertTrue(msg.contains(TOAST_MSG_VERIFICATION));
		
		//homePage.logout();
		
		//driver.quit();
	}
	
	@Test(groups = "smoke")
	public void addProductLaptop() throws EncryptedDocumentException, IOException
	{
		/*PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER=pLib.readDataFromPropertyFile("Browser");
		String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");*/
		
		ExcelFileUtility eLib=new ExcelFileUtility();
		String PRODUCT_NAME = eLib.readDataFromExcelFile("Products", 2, 1);
		String CATEGORY_DD = eLib.readDataFromExcelFile("Products", 2, 2);
		String QUANTITY = eLib.readDataFromExcelFile("Products", 2, 3);
		String PRICE = eLib.readDataFromExcelFile("Products", 2, 4);
		String VENDOR_ID_DD = eLib.readDataFromExcelFile("Products", 2, 5);
		String TOAST_MSG_VERIFICATION = eLib.readDataFromExcelFile("Products", 2, 6);
		
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
		driver.manage().window().maximize();
		
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.implicitWait(driver);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);*/
		
		HomePage homePage=new HomePage(driver);
		homePage.getProductsLink().click();
		
		ProductsPage productsPage=new ProductsPage(driver);
		productsPage.getAddProductBtn().click();
		
		JavaUtility jLib=new JavaUtility();
		AddProductPage addProductPage=new AddProductPage(driver);
		addProductPage.getProductNameTF().sendKeys(PRODUCT_NAME+jLib.generateRandomNumber());
		
		WebElement Category_DD = addProductPage.getSelectCategoryDD();
		wLib.select(Category_DD, CATEGORY_DD);
		
		addProductPage.getQuantityTF().clear();
		addProductPage.getQuantityTF().sendKeys(QUANTITY);
		
		addProductPage.getPriceTF().clear();
		addProductPage.getPriceTF().sendKeys(PRICE);
		
		WebElement Vendor_DD = addProductPage.getSelectVendorDD();
		wLib.select(Vendor_DD, VENDOR_ID_DD);
		
		addProductPage.getAddBtn().click();
		
		WebElement toastMsg=homePage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		String msg=toastMsg.getText();
		/*if(msg.contains(TOAST_MSG_VERIFICATION))
			System.out.println("Product added");
		else
			System.out.println("Product not added");*/
		homePage.getCloseToastMsg().click();
		Assert.assertTrue(msg.contains(TOAST_MSG_VERIFICATION));
		
		//homePage.logout();
		
		//driver.quit();
	}
	
	@Test(groups = "regression")
	public void addProductTV() throws EncryptedDocumentException, IOException
	{
		/*PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER=pLib.readDataFromPropertyFile("Browser");
		String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");*/
		
		ExcelFileUtility eLib=new ExcelFileUtility();
		String PRODUCT_NAME = eLib.readDataFromExcelFile("Products", 3, 1);
		String CATEGORY_DD = eLib.readDataFromExcelFile("Products", 3, 2);
		String QUANTITY = eLib.readDataFromExcelFile("Products", 3, 3);
		String PRICE = eLib.readDataFromExcelFile("Products", 3, 4);
		String VENDOR_ID_DD = eLib.readDataFromExcelFile("Products", 3, 5);
		String TOAST_MSG_VERIFICATION = eLib.readDataFromExcelFile("Products", 3, 6);
		
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
		driver.manage().window().maximize();
		
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.implicitWait(driver);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);*/
		
		HomePage homePage=new HomePage(driver);
		homePage.getProductsLink().click();
		
		ProductsPage productsPage=new ProductsPage(driver);
		productsPage.getAddProductBtn().click();
		
		JavaUtility jLib=new JavaUtility();
		AddProductPage addProductPage=new AddProductPage(driver);
		addProductPage.getProductNameTF().sendKeys(PRODUCT_NAME+jLib.generateRandomNumber());
		
		WebElement Category_DD = addProductPage.getSelectCategoryDD();
		wLib.select(Category_DD, CATEGORY_DD);
		
		addProductPage.getQuantityTF().clear();
		addProductPage.getQuantityTF().sendKeys(QUANTITY);
		
		addProductPage.getPriceTF().clear();
		addProductPage.getPriceTF().sendKeys(PRICE);
		
		WebElement Vendor_DD = addProductPage.getSelectVendorDD();
		wLib.select(Vendor_DD, VENDOR_ID_DD);
		
		addProductPage.getAddBtn().click();
		
		WebElement toastMsg=homePage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		String msg=toastMsg.getText();
		/*if(msg.contains(TOAST_MSG_VERIFICATION))
			System.out.println("Product added");
		else
			System.out.println("Product not added");*/
		homePage.getCloseToastMsg().click();
		Assert.assertTrue(msg.contains(TOAST_MSG_VERIFICATION));
		
		//homePage.logout();
		
		//driver.quit();
	}
}
