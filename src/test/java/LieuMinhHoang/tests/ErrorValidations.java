package LieuMinhHoang.tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;



import LieuMinhHoang.TestComponents.BaseTest;
import LieuMinhHoang.TestComponents.MyRetryAnalyzer;

public class ErrorValidations extends BaseTest{

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=MyRetryAnalyzer.class)
	public void submitOrder() throws InterruptedException, IOException {
		
		landingPage.loginApplication("danielowen@gmail.com", "0");
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMess());

	}

}
