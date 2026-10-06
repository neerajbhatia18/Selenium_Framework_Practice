import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import PageObjectTestFiles.CartPage;
import PageObjectTestFiles.CheckoutPage;
import PageObjectTestFiles.LandingPage;
import PageObjectTestFiles.ProductCatalouge;
import TestComponent.Base;
import TestComponent.Retry;

public class ErrorValidationTest extends Base {
    
	@Test(groups= {"ErrorHandling"})
	public void LoginerrorValidation() throws IOException{
		// TODO Auto-generated method stub
        ProductCatalouge catalougeObj=landPageObj.loginIntoApplication("bhatianeeraj86@gmail.com", "Tesst@123");
        Assert.assertEquals(landPageObj.getErrorMessage(), "Incorrect email or password.");
        
        
       }
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void ProductErrorValidation() throws IOException{
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
        
        
		//LandingPage landPageObj=launchApplication();
        ProductCatalouge catalougeObj=landPageObj.loginIntoApplication("bhatianeeraj86@gmail.com", "Test@123");
        catalougeObj.addToCart(productName);
        CartPage cartPageObj=catalougeObj.goToCartPage();
   
        Boolean match=cartPageObj.verifyProductDisplay("ZARA COAT 3");
        Assert.assertTrue(match);
      
	    
	 
	    
	}

}
