package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {

	WebDriver driver;
	public AddProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productName") private WebElement productNameTF;
	@FindBy(name="productCategory") private WebElement selectCategoryDD;
	@FindBy(name="vendorId") private WebElement selectVendorDD;
	@FindBy(name="quantity") private WebElement quantityTF;
	@FindBy(name="price") private WebElement priceTF;
	@FindBy(xpath="//button[@type='submit']") private WebElement addBtn;
	public WebElement getProductNameTF() {
		return productNameTF;
	}
	public WebElement getSelectCategoryDD() {
		return selectCategoryDD;
	}
	public WebElement getSelectVendorDD() {
		return selectVendorDD;
	}
	public WebElement getQuantityTF() {
		return quantityTF;
	}
	public WebElement getPriceTF() {
		return priceTF;
	}
	public WebElement getAddBtn() {
		return addBtn;
	}
	
}
