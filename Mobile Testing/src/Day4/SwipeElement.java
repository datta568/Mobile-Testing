package Day4;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeElement {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities capability= new DesiredCapabilities();
		capability.setCapability("deviceName", "Manzoor");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//capability.setCapability(MobileCapabilityType.NO_RESET, true);
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.findElementByAccessibilityId("Search tab").click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Search\")")).sendKeys("Maths");
		driver.hideKeyboard();
		Thread.sleep(5000);
		TouchAction act = new TouchAction(driver);
		Dimension d=driver.manage().window().getSize();
		int width=d.width;
		int height=d.height;
		int x1=width/2;
		int y1=4*height/5;
		int x2=width/2;
		int y2=height/5;
		act.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2, y2)).release().perform();
		act.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2, y2)).release().perform();


	}

}
