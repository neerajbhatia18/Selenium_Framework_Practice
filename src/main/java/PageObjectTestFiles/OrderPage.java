package PageObjectTestFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

	
public class OrderPage extends AbstractComponents{
		 
		WebDriver driver;
		
		public OrderPage(WebDriver driver) {
			super(driver);
			this.driver= driver;
			PageFactory.initElements(driver, this);
		}


		@FindBy(xpath="//tr/td[2]")
		List<WebElement> orderPageProduct;
		
		public boolean verifyOrderDisplay(String productName)
		{   
			waitForElementToAppear(orderPageProduct);
			//boolean anyMatch=orderPageProduct.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
			boolean anyMatch=orderPageProduct.stream()
		    .findFirst()
		    .map(s -> s.getText().equalsIgnoreCase(productName))
		    .orElse(false);
			return anyMatch;
		}

}
