package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkingWithIRetryAnalyzer {

	@Test(retryAnalyzer=genericutilities.IRetryImplementation.class)
	public void retryAnalyzer()
	{
		System.out.println("test");
		Assert.assertEquals("hdfc", "hdFc");
	}
}
