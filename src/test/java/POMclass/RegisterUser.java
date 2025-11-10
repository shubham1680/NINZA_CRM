package POMclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterUser {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\LoginData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String URL=pobj.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\RegistrationDetails.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String FIRSTNAME=wb.getSheet("Registration").getRow(0).getCell(1).getStringCellValue();
		String LASTNAME=wb.getSheet("Registration").getRow(0).getCell(3).getStringCellValue();
		String EMAIL=wb.getSheet("Registration").getRow(0).getCell(5).getStringCellValue();
		String PASSWORD=wb.getSheet("Registration").getRow(0).getCell(7).getStringCellValue();
		
		RegisterPage rp = new RegisterPage(driver);
		rp.getFirstName().sendKeys(FIRSTNAME);
		rp.getLastName().sendKeys(LASTNAME);
		rp.getEmail().sendKeys(EMAIL);
		rp.getPassword().sendKeys(PASSWORD);
		
	}

}
