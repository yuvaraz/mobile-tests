package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class LoginPage extends BasePage{

	

	public LoginPage(AppiumDriver<WebElement> driver) {
		super(driver);
	}
	

	@FindBy(id="com.ebay.mobile:id/edit_text_username")
	public WebElement txtUserName;
	
	@FindBy(id="com.ebay.mobile:id/edit_text_password")
	public WebElement txtPassword;
	
	@FindBy(id="com.ebay.mobile:id/sign_in_classic")
	public WebElement btnLogin;
	
	
	public void userLogin(String email, String password) throws Exception {

		boolean isLoginScreenDisplayed = false;
		try {
			isLoginScreenDisplayed = btnLogin.isDisplayed();
		} catch (Exception e) {
			isLoginScreenDisplayed = false;
		}
		if (isLoginScreenDisplayed) {
			txtUserName.clear();
			Thread.sleep(1000);
			txtUserName.sendKeys(email);
			Thread.sleep(1000);
			txtPassword.clear();
			Thread.sleep(1000);
			txtPassword.sendKeys(password);
			btnLogin.click();

		}

	}
	
}
