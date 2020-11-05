package day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginToDemoWebShop {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "Manohar");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		 AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		driver.get("http://demowebshop.tricentis.com/login");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("manzoorrocks191@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("manipal");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

	}

}
