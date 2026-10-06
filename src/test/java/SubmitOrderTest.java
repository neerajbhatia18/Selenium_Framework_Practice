import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectTestFiles.CartPage;
import PageObjectTestFiles.CheckoutPage;
import PageObjectTestFiles.OrderPage;
import PageObjectTestFiles.ProductCatalouge;
import TestComponent.Base;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class SubmitOrderTest extends Base {
    
	@Test(dataProvider="getData",groups= {"PurchaseOrder"})
	public void submitOrderTest(HashMap<String,String> input) throws IOException{
		// TODO Auto-generated method stub
        
		//LandingPage landPageObj=launchApplication();
        ProductCatalouge catalougeObj=landPageObj.loginIntoApplication(input.get("userName"),input.get("password"));
        catalougeObj.addToCart(input.get("productName"));
        CartPage cartPageObj=catalougeObj.goToCartPage();
   
        Boolean match=cartPageObj.verifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPageObj=cartPageObj.goToCheckout();
        checkoutPageObj.selectCountry("India");
        checkoutPageObj.submitandclick();
	    
	 }
	@Test(dependsOnMethods={"submitOrderTest"})
    public void orderHistoryTest()
    {
    	ProductCatalouge productobj=landPageObj.loginIntoApplication("bhatianeeraj86@gmail.com", "Test@123");
    	OrderPage orderPageObj=landPageObj.goToOrderSection();
    	boolean check=orderPageObj.verifyOrderDisplay("ZARA COAT 3");
    	Assert.assertTrue(check);
    }
	
	/*@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"bhatianeeraj86@gmail.com","Test@123","ZARA COAT 3"} , {"bhatianeeraj98@gmail.com","Home@496","IPHONE 13 PRO"}};
	}*/
	
	@DataProvider
	public Object[][] getData() throws IOException
	{   
		/*HashMap<String,String> map=new HashMap<String, String>();
		map.put("userName", "bhatianeeraj86@gmail.com");
		map.put("password", "Test@123");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String,String> map1=new HashMap<String, String>();
		map1.put("userName", "bhatianeeraj98@gmail.com");
		map1.put("password", "Home@496");
		map1.put("productName", "IPHONE 13 PRO");
		return new Object[][] {{map} , {map1}};*/
		
		List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)} , {data.get(1)}};
	}
	


}
