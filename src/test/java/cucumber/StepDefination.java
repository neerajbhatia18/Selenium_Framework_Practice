package cucumber;

import TestComponent.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.testng.Assert;

import PageObjectTestFiles.CartPage;
import PageObjectTestFiles.CheckoutPage;
import PageObjectTestFiles.LandingPage;
import PageObjectTestFiles.ProductCatalouge;


public class StepDefination extends Base{
	
	public LandingPage landpageobj;
	public ProductCatalouge catalougeObj;
	public CartPage cartPageObj;
	
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException
	{
		landpageobj=launchApplication();
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String Password)
	{
		catalougeObj=landPageObj.loginIntoApplication(username, Password);
	}
	
	@When("^I add the product (.+) to cart$")
	public void I_add_the_Product_to_cart(String productName)
	{
		catalougeObj.addToCart(productName);
		cartPageObj=catalougeObj.goToCartPage();  
	}
	
	@When("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName)
	{
        Boolean match=cartPageObj.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPageObj=cartPageObj.goToCheckout();
        checkoutPageObj.selectCountry("India");
        checkoutPageObj.submitandclick();
	}
	
	@Then("{string} message is displayed")
	public void error_message_is_displayed(String errorMessage)
	{
		 Assert.assertEquals(landPageObj.getErrorMessage(), errorMessage);
	}
	
	

}
