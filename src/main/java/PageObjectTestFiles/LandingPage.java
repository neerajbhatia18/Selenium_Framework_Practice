package PageObjectTestFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{   
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement Passwordelement;
	
	@FindBy(id="login")
	WebElement LoginButton;
	
	@FindBy(css="[class*='flyInOut']")
    WebElement errorToast;
	
	public ProductCatalouge loginIntoApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		Passwordelement.sendKeys(password);
		LoginButton.click();
		ProductCatalouge catalougeObj= new ProductCatalouge(driver);
		return catalougeObj;
	}
	
	public String getErrorMessage()
	{   
		waitForElementToAppear(errorToast);
		return errorToast.getText();
	}
	
	

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	

}
