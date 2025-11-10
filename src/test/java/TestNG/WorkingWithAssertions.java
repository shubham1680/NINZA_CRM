package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithAssertions {

	@Test
	public void HardAssert()
	{
		Assert.assertEquals("apple", "apple");
		System.out.println("next line");
	}
	
	@Test
	public void SoftAssert()
	{
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals("apple", "Apple");
		System.out.println("next line");
		softAssert.assertAll();
	}
}
