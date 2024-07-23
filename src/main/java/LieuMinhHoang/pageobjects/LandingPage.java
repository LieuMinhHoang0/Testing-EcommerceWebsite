package LieuMinhHoang.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LieuMinhHoang.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	
	
//	driver.findElement(By.id("userEmail")).sendKeys("danielowen@gmail.com");
//	driver.findElement(By.id("userPassword")).sendKeys("Flanuermh0");
//	driver.findElement(By.id("login")).click();
	@FindBy(id="userEmail")
	WebElement userName;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="div[class*='toast-bottom-right toast-container']")
	WebElement errorMess;
	public void goTo() { 
		driver.get("https://rahulshettyacademy.com/client");
	}
	public ProductCatalogue loginApplication(String email, String pass) {
		userName.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public String getErrorMess() {
		waitForWebElementToAppear(errorMess);
		return errorMess.getText();
	}
	

}
