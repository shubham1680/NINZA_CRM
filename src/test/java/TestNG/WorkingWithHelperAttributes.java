package TestNG;


import org.testng.Reporter;
import org.testng.annotations.Test;


public class WorkingWithHelperAttributes {

	@Test
	public void productCreation()
	{
		Reporter.log("Product created",true);
	}
	
	
	@Test(dependsOnMethods = {"productCreation","updateProduct"})
	public void deleteProduct() throws InterruptedException
	{
		System.out.println("product deleted");
	}
	
	@Test(dependsOnMethods = "productCreation")
	public void updateProduct()
	{
		Reporter.log("Product updated",true);
	}
}
