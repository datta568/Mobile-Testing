package Day7;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AutoComplete {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Manzoor");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(MobileCapabilityType.NO_RESET, true);
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAccessibilityId("Auto Complete").click();
        driver.findElementByAccessibilityId("1. Screen Top").click();
        driver.findElement(MobileBy.id("io.appium.android.apis:id/edit")).click();

	}

}
