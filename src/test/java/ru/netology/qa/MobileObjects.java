package ru.netology.qa;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {

    @AndroidFindBy(id="com.google.android.calculator:id/digit_2")
    MobileElement btn2;

    @AndroidFindBy(id="com.google.android.calculator:id/op_add")
    MobileElement btnPlus;

    @AndroidFindBy(id="com.google.android.calculator:id/eq")
    MobileElement btnEqual;

    @AndroidFindBy(id="com.google.android.calculator:id/result_final")
    MobileElement result;
    private AppiumDriver driver;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);
    }
}

