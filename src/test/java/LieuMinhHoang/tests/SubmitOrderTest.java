package LieuMinhHoang.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LieuMinhHoang.pageobjects.ProductCatalogue;
import LieuMinhHoang.AbstractComponents.OrderPage;
import LieuMinhHoang.TestComponents.BaseTest;
import LieuMinhHoang.pageobjects.CartPage;
import LieuMinhHoang.pageobjects.CheckoutPage;
import LieuMinhHoang.pageobjects.ConfirmationPage;

public class SubmitOrderTest extends BaseTest{
	String productName = "IPHONE 13 PRO";
	String countryName = "india";
	@Test(dataProvider= "getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String, String> map) throws InterruptedException, IOException {
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(map.get("email"), map.get("pass"));
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addToCart(map.get("productName"));
		CartPage cartPage = productCatalogue.goToCart();

		Boolean match = cartPage.verifyProductDisplay(map.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckOut();
		
		ConfirmationPage confirmationPage = checkoutPage.selectCountry(countryName);
		String confirmMess = confirmationPage.getConfirmationMess();
		
		
		Assert.assertTrue(confirmMess.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("danielowen@gmail.com", "Flanuermh0");
		OrderPage orderPage = productCatalogue.goToOrder();
		Assert.assertTrue(orderPage.verifyProductDisplay(productName));
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"danielowen@gmail.com", "Flanuermh0", "IPHONE 13 PRO"}, {"danielowen1@gmail.com", "owen1", "IPHONE 13 PRO"}};
//	}
//	@DataProvider
//	public Object[][] getData() {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "danielowen@gmail.com");
//		map.put("pass", "Flanuermh0");
//		map.put("productName", "IPHONE 13 PRO");
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "danielowen@gmail.com");
//		map1.put("pass", "Flanuermh0");
//		map1.put("productName", "IPHONE 13 PRO");
//		return new Object[][] {{map}, {map1}};
//	}	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\LieuMinhHoang\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	

	

}
