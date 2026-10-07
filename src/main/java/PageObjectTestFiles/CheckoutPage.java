package PageObjectTestFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{   
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="*[placeholder='Select Country']")
	WebElement countryField;
	
	@FindBy(css=".ta-item:nth-child(3)")
    WebElement selectCountry;
	
	@FindBy(xpath="//*[contains(@class,'action__submit')]")
	WebElement submit;
    
    By countryDropdown=(By.cssSelector(".ta-item"));
    
    public void selectCountry(String countryName)
    {
	Actions a=new Actions(driver);
	a.sendKeys(countryField, countryName).build().perform();
	waitForElementToAppear(countryDropdown);
	selectCountry.click();
    }
    
    public void submitandclick()
    {
    	   JavascriptExecutor js = (JavascriptExecutor) driver; //scrolling
    	   js.executeScript("window.scrollBy(0,400)");
    	   js.executeScript("arguments[0].click();", submit);
    	
    	    
    }
   
    
 
	

}
