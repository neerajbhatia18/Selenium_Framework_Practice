package PageObjectTestFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	 WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection H3")
	List<WebElement> cartProductList;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutButton;
	
	By cartProducts=By.cssSelector(".cartSection H3");
	
	
	public Boolean verifyProductDisplay(String productName)
	{
		waitForElementToAppear(cartProducts);
		Boolean matchProduct=cartProductList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return matchProduct;
	}
	
	public CheckoutPage goToCheckout()
	{   
		
		checkoutButton.click();
		CheckoutPage checkoutPageObj= new CheckoutPage(driver);
		return checkoutPageObj;
		
	}
	
	
	

}
