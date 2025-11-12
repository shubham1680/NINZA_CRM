package POMPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8098/");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUsername("rmgyantra");
		loginPage.setPassword("rmgy@9999");
		loginPage.clickSignIn();
		
		

	}

}
