package Day6;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class RecentApplicationsLaunching {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Manzoor");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.july.cricinfo");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.espn.framework.ui.FrameworkLaunchActivity");
        capability.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

	}

}
