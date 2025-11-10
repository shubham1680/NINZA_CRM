package ScreenShotPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class screenShotPractice3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/");
		
		/*driver.findElement(By.name("username")).sendKeys("dsfsdf");
		driver.findElement(By.name("password")).sendKeys("65465465465");*/
		
		WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
		File temp=login.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Screenshot/login.png");
		FileHandler.copy(temp, perm);
		
		
		
		/*WebElement un=driver.findElement(By.id("userName"));
		File temp=un.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Screenshot/username.png");
		FileHandler.copy(temp, perm);*/

	}

}
