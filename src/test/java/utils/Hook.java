package utils;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Hook {
//    private static WebDriver driver;
    private static AppiumDriver appiumDriver;

    @Before("@appium")
    public void setUpAppium() throws MalformedURLException
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setPlatformVersion("12");
        options.setAppPackage("wrteam.multivendor.customer");
        options.setAppActivity("wrteam.multivendor.customer.activity.SplashActivity");
//        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        if (driver != null){
//            System.out.println("driver is not null");
//        } else System.out.println("driver is null");
        appiumDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (appiumDriver != null){
            System.out.println("driver is not null");
        } else System.out.println("driver is null");
    }

    @After
    public void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

    public static AppiumDriver getDriver() {
        return appiumDriver;
    }
}
