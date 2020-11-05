package Day7;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ExceptionHandling {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Manzoor");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(MobileCapabilityType.NO_RESET, true);
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.july.cricinfo");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.espn.framework.ui.FrameworkLaunchActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"LOG IN\")")).click();
        driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("manzoor@gmail.com");
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password (case sensitive)\")")).sendKeys("manzoor");;
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password (case sensitive)\")")).click();
        		try {
        	        String error =driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().textContains(\"The Credentials\")")).getText();
        	        System.out.println("error message on the screen "+error);
        	        }catch(NoSuchElementException e) {
        	        String succes=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Tap your favourite teams\")")).getText();
        	        System.out.println("successful login "+succes);
        	        }

	}

}
