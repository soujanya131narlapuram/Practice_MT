package com.bridgelabz.calc.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FlipkartLaunch_GenyEmulator
{


    AndroidDriver driver;
    WebDriverWait wait;
        @Test
        public void createSession() throws MalformedURLException, InterruptedException
        {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName","Google Pixel 2");
            cap.setCapability("platformName","Android");
            cap.setCapability("platformVersion","9.0");
            cap.setCapability("autoGrantPermissions",true);
            cap.setCapability("adb",true);

            cap.setCapability("app","C:\\Users\\narla\\IdeaProjects\\Calculator_MobileTesting\\src\\main\\resources\\Flipkart-7.18.apk");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.setFileDetector(new LocalFileDetector());
            Thread.sleep(10000);
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.RelativeLayout")).click();
            Thread.sleep(9000);
            driver.findElement(By.id("com.flipkart.android:id/select_btn")).click();
            Thread.sleep(4000);
            System.out.println("Flipkart launched!!");
            Thread.sleep(9000);
            driver.findElement(By.id("com.flipkart.android:id/tv_right_cta")).click();
            Thread.sleep(9000);
            driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys("soujanya131narlapuram@gmail.com");
            Thread.sleep(9000);
            driver.findElement(By.id("com.flipkart.android:id/button")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("com.flipkart.android:id/tv_right_cta")).click();
            Thread.sleep(9000);
            driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys("soujanya131narlapuram@gmail.com");
            Thread.sleep(9000);
            driver.findElement(By.id("com.flipkart.android:id/button")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys("9381220872");
            Thread.sleep(9000);
            driver.findElement(By.id("com.flipkart.android:id/button")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys("9381220872");
            Thread.sleep(9000);
            driver.findElement(By.id("com.flipkart.android:id/button")).click();
            Thread.sleep(5000);
        }
    }


