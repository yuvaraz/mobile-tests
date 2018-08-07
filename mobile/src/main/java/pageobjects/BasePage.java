package pageobjects;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class BasePage{

	protected static WebDriverWait wait = null;
	protected static  TouchAction<?> touchAction = null;
	protected static Alert alert = null;


	protected AppiumDriver<WebElement> driver;
	//public final WebDriver driver;
	public BasePage(AppiumDriver<WebElement>  driver) {
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}


	@FindBy(id="com.ebay.mobile:id/button_sign_in")
	public WebElement btnSignIn;
	
	@FindBy(id="com.ebay.mobile:id/button_register")
	public WebElement btnRegister;
	
	@FindBy(id="com.ebay.mobile:id/search_box")
	public WebElement txtSearchBox;
	
	@FindBy(id="com.ebay.mobile:id/home")
	public WebElement mnuHome;
	
	
	

	
	public void acceptNativeAlerts() throws InterruptedException {
		try {
			alert = driver.switchTo().alert();
			System.out.println("Native alert handled");
			alert.accept();
			Thread.sleep(2000);

		} catch (NoSuchElementException | TimeoutException e) {
		}
	}

	

	public void scrollToElementVisible(WebElement ele) {

		HashMap<String, String> scrollObject = new HashMap<String, String>();
		RemoteWebElement element = (RemoteWebElement) (ele);
		// String elementId = element.getId();
		scrollObject.put("element", element.getId());
		scrollObject.put("toVisible", "not an empty string");
		driver.executeScript("mobile:scroll", scrollObject);
	}



	public  void scrollDown() throws InterruptedException {
		
		Dimension size = driver.manage().window().getSize();
		
		int x = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.7);
		int endy = (int) (size.getHeight() * 0.3);
		touchAction = new TouchAction<>(driver);
		int i=1;  
		do{  
			touchAction.longPress(point(x, endy)).moveTo(point(x,starty)).release().perform();
			//touchAction.longPress(point(x, endy)).waitAction(waitOptions(Duration.ofSeconds(2))).moveTo(point(x,starty)).release().perform();
			//touchAction.longPress(x, endy).moveTo(x, starty).release().perform();

			Thread.sleep(2000);  
			i++;  
		}while(i<=5);
		
	}

	public  void scrollUp() throws InterruptedException {
	
		Dimension size = driver.manage().window().getSize();

		int x = size.getWidth() / 2;
		int starty = (int) (size.getHeight() *0.7);
		int endy = (int) (size.getHeight() * 0.3);
		touchAction = new TouchAction<>(driver);
		touchAction.longPress(point(x, starty)).moveTo(point(x,endy)).release().perform();
		//touchAction.longPress(point(x, starty)).waitAction(waitOptions(Duration.ofSeconds(2))).moveTo(point(x,endy)).release().perform();
		//touchAction.longPress(x, starty).moveTo(x, endy).release().perform();
		Thread.sleep(2000);  
		


	}

	public void horizontalSwipe() throws InterruptedException {
		
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		Thread.sleep(3000);

		int endx = (int) (size.getWidth() * 0.30);
		int startx = (int) (size.getWidth() * 0.60);
		int y = size.getHeight() / 2;
		System.out.println("startx = " + startx + " ,endx = " + endx + " , y = " + y);

		touchAction = new TouchAction<>(driver);
		touchAction.press(point(startx, y)).moveTo(point(endx, y)).release().perform();
		//touchAction.press(startx, y).waitAction().moveTo(endx, y).release().perform();
		Thread.sleep(2000);
		
	}



	

	

}
