package ru.netology.qa;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumTest {

    private AndroidDriver driver;

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
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Some name1");
        caps.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        caps.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), caps);

    }

    @Test
    public void SampleOneTest() {
        MobileElement el1 = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el1.click();
        MobileElement el3 = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el3.sendKeys("          ");
        MobileElement el4 = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
        el5.isDisplayed();

        Assertions.assertEquals("Привет, UiAutomator!", el5.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

