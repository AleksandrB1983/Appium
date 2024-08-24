package ru.netology.qa;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    private AndroidDriver driver;
    private MobileObjects mobileObjects;
    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:deviceName", "some name");
        caps.setCapability("appium:appPackage", "com.google.android.calculator");
        caps.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);



        driver = new AndroidDriver(this.getUrl(), caps);

        mobileObjects = new MobileObjects(driver);
    }

    @Test
    public void sampleTest() {
        mobileObjects.btn2.isDisplayed();
        mobileObjects.btn2.click();

        mobileObjects.btnPlus.isDisplayed();
        mobileObjects.btnPlus.click();

        mobileObjects.btn2.isDisplayed();
        mobileObjects.btn2.click();

        mobileObjects.btnEqual.isDisplayed();
        mobileObjects.btnEqual.click();

        mobileObjects.result.isDisplayed();
        Assertions.assertEquals("4", mobileObjects.result.getText());

    }

    //   @Test
    //   public void sampleTest() {
    //       MobileElement el2 = (MobileElement) driver.findElement(By.id(""));
    //       el2.click();
    //       MobileElement el3 = (MobileElement) driver.findElement(By.id(""));
    //       el3.click();
    //       MobileElement el4 = (MobileElement) driver.findElement(By.id(""));
    //       el4.click();
    //       MobileElement el5 = (MobileElement) driver.findElement(By.id(""));
    //       el5.click();
    //       MobileElement el6 = (MobileElement) driver.findElement(By.id(""));
    //       el6.isDisplayed();
    //
    //       Assertions.assertEquals("4", el6.getText());
    //   }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
