package Day2;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class ClickOnDesktopIcon {
	public AndroidDriver driver;
    @Test
    public void firstTest() {
    	driver.findElement(By.xpath("//span[@class='icon']")).click();
    	driver.findElement(By.xpath("//a[contains(text(),'Computers')]//following-sibling::span")).click();
    	driver.findElement(By.xpath("//ul[@class='mob-top-menu show']//li//a[contains(text(),'Desktops')]")).click();
    }
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
    	DesiredCapabilities capability= new DesiredCapabilities();
    	capability.setCapability("deviceName", "Manzoor");
    	capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    	capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    	driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
    	driver.get("http://demowebshop.tricentis.com");
    }

    @AfterClass
    public void afterClass() {
    	driver.close();
    }

}
