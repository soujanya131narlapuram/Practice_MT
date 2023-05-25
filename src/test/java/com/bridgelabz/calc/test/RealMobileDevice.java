package com.bridgelabz.calc.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RealMobileDevice {
    AndroidDriver driver;


    @Test
    public void createSession() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "V2029");
        cap.setCapability("app", "Browser");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");
        cap.setCapability("BROWSER_NAME", "Android");
        cap.setCapability("automationName","UiAutomator1");
        cap.setCapability("autoGrantPermissions",true);
        cap.setCapability("app", "C:\\Users\\narla\\IdeaProjects\\Calculator_MobileTesting\\src\\main\\resources\\chrome.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Thread.sleep(4000);
        String baseurl = "https://www.google.com";
        driver.get(baseurl);


    }
}
