package com.bridgelabz.calc.test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeWebsiteLaunch {
        AndroidDriver driver;
        @Test
        public void createSession() throws MalformedURLException, InterruptedException {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName","emulator-5554");
            cap.setCapability("app", "Browser");
            cap.setCapability("platformName","Android");
            cap.setCapability("platformVersion","9.0");
            cap.setCapability("app","C:\\Users\\narla\\IdeaProjects\\Calculator_MobileTesting\\src\\main\\resources\\chrome.apk");
            //cap.setCapability("chromeDriverExecutable", "C:\\Users\\Admin\\Documents\\QADevPrograms\\CFPMobileAutomation\\src\\main\\resources\\chromedriver.exe");
            //cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
            Thread.sleep(3000);
            driver.get("https://www.amazon.com/");
            Thread.sleep(3000);
            driver.findElement(AppiumBy.id("nav-search-keywords")).sendKeys("Iphone");
            System.out.println("Amazon website launched!!");
        }
   }

