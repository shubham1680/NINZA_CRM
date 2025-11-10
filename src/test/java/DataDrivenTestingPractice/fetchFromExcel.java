package DataDrivenTestingPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fetchFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String USERNAME=wb.getSheet("LoginData").getRow(2).getCell(0).getStringCellValue();
		String PASSWORD=wb.getSheet("LoginData").getRow(2).getCell(1).getStringCellValue();
		wb.close();
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		

	}

}
