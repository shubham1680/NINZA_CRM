package genericutilities;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import objectrepository.HomePage;
import objectrepository.LoginPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	public WebDriver driver=null;
	public WebDriverUtility wLib=new WebDriverUtility();
	public PropertyFileUtility pLib=new PropertyFileUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public static WebDriver sdriver=null;
	
  @BeforeSuite(groups = {"smoke","regression"})
  public void beforeSuite() {
	  System.out.println("Establish the database connection");
  }
  @BeforeTest(groups = {"smoke","regression"})
  public void beforeTest() {
	  System.out.println("Pre-conditions for parallel execution");
  }
  @BeforeClass(groups = {"smoke","regression"})
  public void beforeClass() throws IOException {
	  System.out.println("Launch the browser");
	  String BROWSER=pLib.readDataFromPropertyFile("Browser");
	  ChromeOptions options=new ChromeOptions();
		Map<String,Object> prefs=new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--guest");
		
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver(options);
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(BROWSER.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else if(BROWSER.equalsIgnoreCase("safari"))
			driver=new SafariDriver();
		sdriver=driver;
		driver.manage().window().maximize();
		
		wLib.implicitWait(driver);
  }
	  
  @BeforeMethod(groups = {"smoke","regression"})
  public void beforeMethod() throws IOException {
	  System.out.println("Login");
	  String URL=pLib.readDataFromPropertyFile("URL");
		String USERNAME=pLib.readDataFromPropertyFile("Username");
		String PASSWORD=pLib.readDataFromPropertyFile("Password");
	  LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);
  }

  @AfterMethod(groups = {"smoke","regression"})
  public void afterMethod() {
	  System.out.println("Logout");
	  HomePage homePage=new HomePage(driver);
	  homePage.logout();
  }

  @AfterClass(groups = {"smoke","regression"})
  public void afterClass() {
	  System.out.println("Close the browser");
	  driver.quit();
  }

  @AfterTest(groups = {"smoke","regression"})
  public void afterTest() {
	  System.out.println("Post-conditions for parallel execution");
  }

  @AfterSuite(groups = {"smoke","regression"})
  public void afterSuite() {
	  System.out.println("Close the database connection");
  }

}
