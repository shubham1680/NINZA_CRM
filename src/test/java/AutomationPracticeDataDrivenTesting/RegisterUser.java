package AutomationPracticeDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUser {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FileInputStream fis=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\RegisterUser.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL=prop.getProperty("URL");
		String NAME=prop.getProperty("Name");
		String EMAIL=prop.getProperty("Email");
		String PASSWORD=prop.getProperty("Password");
		
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\AutomationExercise.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String FIRST_NAME=wb.getSheet("RegisterUser").getRow(1).getCell(2).getStringCellValue();
		String LAST_NAME=wb.getSheet("RegisterUser").getRow(1).getCell(3).getStringCellValue();
		String ADDRESS=wb.getSheet("RegisterUser").getRow(1).getCell(4).getStringCellValue();
		String STATE=wb.getSheet("RegisterUser").getRow(1).getCell(5).getStringCellValue();
		String CITY=wb.getSheet("RegisterUser").getRow(1).getCell(6).getStringCellValue();
		String ZIPCODE=wb.getSheet("RegisterUser").getRow(1).getCell(7).getStringCellValue();
		String MOBILE=wb.getSheet("RegisterUser").getRow(1).getCell(8).getStringCellValue();
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		WebElement text1=driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOf(text1));
		if(text1.isDisplayed())
			System.out.println("Webpage visible");
		else
			System.out.println("Not visible");
		driver.findElement(By.name("name")).sendKeys(NAME);
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(EMAIL);
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		WebElement text2=driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOf(text2));
		if(text2.isDisplayed())
			System.out.println("Webpage visible");
		else
			System.out.println("Webpage not visible");
		
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		WebElement days = driver.findElement(By.id("days"));
		Select obj1=new Select(days);
		obj1.selectByValue("12");
		
		WebElement months = driver.findElement(By.id("months"));
		Select obj2=new Select(months);
		obj2.selectByVisibleText("December");
		
		WebElement years = driver.findElement(By.id("years"));
		Select obj3=new Select(years);
		obj3.selectByValue("1998");
		
		driver.findElement(By.id("first_name")).sendKeys(FIRST_NAME);
		driver.findElement(By.id("last_name")).sendKeys(LAST_NAME);
		driver.findElement(By.id("address1")).sendKeys(ADDRESS);
		driver.findElement(By.id("state")).sendKeys(STATE);
		driver.findElement(By.id("city")).sendKeys(CITY);
		driver.findElement(By.id("zipcode")).sendKeys(ZIPCODE);
		driver.findElement(By.id("mobile_number")).sendKeys(MOBILE);
		
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		
		WebElement text3 = driver.findElement(By.xpath("//b[text()='Account Created!']"));
		if(text3.isDisplayed())
			System.out.println("webpage visible");
		else
			System.out.println("webpage not visible");
		
		driver.findElement(By.linkText("Continue")).click();
		
		WebElement ele = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
		if(ele.isDisplayed())
			System.out.println("Webpage visible");
		else
			System.out.println("webpage not visible");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
		WebElement text4 = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(text4));
		if(text4.isDisplayed())
			System.out.println("webpage visible");
		else
			System.out.println("webpage not visible");
		
		driver.findElement(By.linkText("Continue")).click();
		
		

	}

}
