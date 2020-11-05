package Day6;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WorkingWithHybridApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Manzoor");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"India\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Enter name here\")")).sendKeys("Manohar");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(5000);
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).click();
        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);        
        System.out.println("current context of application is "+driver.getContext());
        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(3000);
        System.out.println("list of context on the application are "+driver.getContextHandles());
        Thread.sleep(3000);
        driver.context("WEBVIEW_com.androidsample.generalstore");
        System.out.println("current context of application is "+driver.getContext());
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Manohar");
        

	}

}
