package testcases;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class VerifyBuyProduct extends TestBase{
	
	LoginPage loginPage;

	@BeforeClass
	public void pageObejectsInitialization() throws Exception {

	
		loginPage = new LoginPage(driver);
		wait = new WebDriverWait(driver, 30);
	

	}

	@Parameters({ "username", "password" })
	@Test(priority = 0)
	public void addProductToCart(@Optional("yuvaraz17@gmail.com")String uname, @Optional("test@1234")String password) throws Exception, IOException {

		loginPage.userLogin(uname, password);
		
		

		
	}


}
