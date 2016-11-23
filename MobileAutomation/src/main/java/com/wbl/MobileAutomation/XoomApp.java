package com.wbl.MobileAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class XoomApp {

	AndroidDriver<WebElement> driver;
	
	@BeforeClass
	public void setUp()
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		//setting capabilities for platform and version
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.VERSION, "5.1.1");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "22");
		//setting capabilities for apk file
		dc.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+ "\\resources\\Xoom.apk");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.xoom.andriod.app");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.xoom.andriod.app.MainActivity_");
		
		// creating the driver to give appium n port no. for Andriod
		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4725/wd/hub"),dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.closeApp();
		driver.removeApp("Xoom.apk");
		}

}
