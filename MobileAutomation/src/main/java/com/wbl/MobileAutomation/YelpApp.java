package com.wbl.MobileAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class YelpApp 
{
	AndroidDriver<WebElement> driver;
	
	@BeforeClass
	public void setUp()// for install  the yelp app on  an Android(Nexus6) emulator
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		//setting capabilities for platform and version
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.VERSION, "5.1.1");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "22");
		//setting capabilities for apk file
		dc.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+ "\\resources\\yelp.apk");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.yelp.android");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.yelp.android.ui.activities.RootActivity");
		
		// creating the driver to give appium n port no. for Andriod
		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4725/wd/hub"),dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		}
	
	@ Test
    public void testYelp () throws InterruptedException
    {
	//for real device 
		//driver.unlockDevice();
		//driver.hideKeyboard();
		//driver.lockDevice();
		
		driver.findElementByXPath("//android.widget.Button[@text='Get Started!']").click();
    	//driver.findElementByName("Get Started!").click();
    	Thread.sleep(3000);
    	driver.findElementByName("First Name").sendKeys("rina singh");
    	Thread.sleep(3000);
    	driver.findElementByName("Last Name").sendKeys("tej");
    	Thread.sleep(3000);
    	driver.findElementById("com.yelp.android:id/email_address").sendKeys("rinasingh4@gmail.com");
    	Thread.sleep(3000);
    	driver.findElementById("com.yelp.android:id/password").sendKeys("abcdef");
    	driver.findElementByName("Zip").sendKeys("95391");
    	Thread.sleep(3000);
    	driver.findElementByName("Gender").click();
    	Thread.sleep(3000);
    	driver.findElementByName("Female").click();
    	Thread.sleep(3000);
    	
    	//driver.findElementByName("Birthdate").click();
    	driver.findElementByName("OK").click();
    	driver.findElementById("com.yelp.android:id/signup_button").click();
    	
    	
    	driver.closeApp();
    	driver.removeApp("yelp.apk");
	
    }
}
