package Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\RegistrationDetails.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Registration");
		Row row=sh.getRow(0);
		Cell cell=row.getCell(1);
		
		String FIRSTNAME=cell.getStringCellValue();
		String LASTNAME=wb.getSheet("Registration").getRow(0).getCell(3).getStringCellValue();
		String EMAIL=wb.getSheet("Registration").getRow(0).getCell(5).getStringCellValue();
		String PASSWORD=wb.getSheet("Registration").getRow(0).getCell(7).getStringCellValue();
		String CPASSWORD=wb.getSheet("Registration").getRow(0).getCell(7).getStringCellValue();
		wb.close();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/register");
		driver.findElement(By.id("FirstName")).sendKeys(FIRSTNAME);
		driver.findElement(By.id("LastName")).sendKeys(LASTNAME);
		driver.findElement(By.id("Email")).sendKeys(EMAIL);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(CPASSWORD);
	}

}
