package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class WorkingWithParameters {
	
	@Parameters("browser")
	@Test
	public void test(String browser)
	{
		System.out.println("Browser is:"+browser);
	}
	
}
