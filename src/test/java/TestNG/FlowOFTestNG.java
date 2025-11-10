package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FlowOFTestNG {
	
	
	@Test(priority=10)
	public void m1()
	{
		System.out.println("Method-1");
	}
	@Test(priority=4)
	public void m2()
	{
		System.out.println("Method-2");
	}
	@Test(priority=-5)
	public void m4()
	{
		System.out.println("Method-4");
	}
	@Test(priority=-5)
	public void m6()
	{
		System.out.println("Method-6");
	}
	@Test(priority=2)
	public void m3()
	{
		System.out.println("Method-3");
	}
	@Test(priority=-3)
	public void m5()
	{
		System.out.println("Method-5");
	}
	

}
