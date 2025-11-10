package DataDrivenTestingPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\dshub\\OneDrive\\Documents\\LoginData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String URL=pObj.getProperty("url");
		String EMAIL=pObj.getProperty("email");
		String PASSWORD=pObj.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@class='_aa4b _add6 _ac4d _ap35']")).sendKeys(EMAIL);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		
		

	}

}
