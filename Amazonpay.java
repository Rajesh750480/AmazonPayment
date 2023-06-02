package Practiceset1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileBy;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import java.util.concurrent.TimeUnit;

public class Amazonpay {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://www.amazon.in/");
		d.manage().window().maximize();
		Thread.sleep(10000);
		
		
		//Login page
		d.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute'][1]")).click();
		d.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")).sendKeys("+917504808052");
		d.findElement(By.xpath("//input[@class='a-button-input']")).click();
		d.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")).sendKeys("********");
		d.findElement(By.xpath("//input[@class='a-button-input'][@id='signInSubmit']")).click();
		
		//Auto enter the OTP 
		/* 
		// Desired capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "my device name");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage nm", "com.messagingapp.package");
		capabilities.setCapability("appActivity nm", "com.messagingapp.activity");

		Create the Appium driver and connect mobile device
		AppiumDriver<MobileElement> appiumDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);

		// Locate OTP and retrieve the OTP
		MobileElement otpMessage = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Your OTP\")"));
		String otpCode = extractOtpFromMessage(otpMessage.getText()); // to extract the OTP from message

		// Close mobile messaging app
		appiumDriver.closeApp();

		d.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/form/div[7]/span/span/input")).sendKeys(otpCode);

		d.findElement(By.xpath("")).click();
		appiumDriver.quit();
		*/
		Thread.sleep(10000);
		//d.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/form/div[7]/span/span/input")).click();
		
		//Search Product
		d.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("scalpe pro anti-dandruff shampoo 100ml");	
		d.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(3000);
		JavascriptExecutor jsc=(JavascriptExecutor)d;
		
		jsc.executeScript("window.scrollBy(0,700)", "");
//		WebElement scalpe=d.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/div/div/div[1]/span/a/div/img"));
//		jsc.executeScript("arguments[0].scrollIntoView(true)", scalpe);
		
		d.findElement(By.xpath("//button[@id='a-autoid-5-announce']")).click();
		Thread.sleep(6000);
		jsc.executeScript("window.scrollBy(0,-2500)", "");
		//WebElement cart=d.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']"));
		//jsc.executeScript("arguments[0].scrollIntoView(true)", cart);
		
		//Go to cart
		Thread.sleep(7000);
		d.findElement(By.xpath("//Span[@class='nav-cart-count nav-progressive-attribute nav-progressive-content nav-cart-1']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//input[@value='Proceed to checkout']")).click();
		Thread.sleep(3000);
		
		//use this address
		d.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div/div[2]/span/span/span/span/input")).click();
		//paylater click
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@value='instrumentId=AmazonCredit&isExpired=false&paymentMethod=CC&tfxEligible=false']")).click();
		Thread.sleep(3000);
		//use this payment method
		d.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div/div[2]/span/span/span/span/input")).click();
		Thread.sleep(5000);
		
		//No thanks Prime
		String window= d.getWindowHandle(); 
	 d.switchTo().window(window);
	d.findElement(By.xpath("//span[@id='prime-interstitial-nothanks-button']")).click();
	String parentWindowHandler = d.getWindowHandle();
	d.switchTo().window(parentWindowHandler);
	Thread.sleep(8000);
	//Order Place with payment
	d.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div/span/span/input")).click();
	
	
	
	}

}
