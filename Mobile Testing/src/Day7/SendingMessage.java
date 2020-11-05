package Day7;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SendingMessage {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Manzoor");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(MobileCapabilityType.NO_RESET, true);
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("OS").click();
        driver.findElementByAccessibilityId("SMS Messaging").click();
        driver.findElementById("io.appium.android.apis:id/sms_recipient").sendKeys("7865");
        driver.findElementById("io.appium.android.apis:id/sms_content").sendKeys("Demo OTP:4567");
        driver.hideKeyboard();
        driver.findElementByAccessibilityId("Send").click();        
        driver.activateApp("com.google.android.apps.messaging");
        Thread.sleep(10000);
        String otpValue=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"You: Demo OTP:4567\")")).getText();
        System.out.println("OTP value is "+otpValue);
        

	}

}
