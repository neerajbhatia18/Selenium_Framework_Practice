package AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjectTestFiles.CartPage;
import PageObjectTestFiles.OrderPage;

public class AbstractComponents {
    
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement orderButton;
	
	By toastMessage=By.cssSelector(".toast-message");
  
	 public void waitForElementToAppear(By findBy)
     {
    	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
     }
	 
	 public void waitForElementToAppear(List<WebElement> findBy)
     {
    	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.visibilityOfAllElements(findBy));
     }
	 
	 public void waitForElementToAppear(WebElement findBy)
     {
    	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.visibilityOf(findBy));
     }
	 
	 public void waitForElementToDisAppear(By findBy)
     {
    	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
     }
	 
	 
	 public CartPage goToCartPage()
	 {   
		 waitForElementToDisAppear(toastMessage);
		 cartButton.click();
	     CartPage cartPageObj= new CartPage(driver);
	     return cartPageObj;
	 }
	 
	 public OrderPage goToOrderSection()
		{   
			waitForElementToAppear(orderButton);
			orderButton.click();
			OrderPage orderpageobj=new OrderPage(driver);
			return orderpageobj;
		}

}
