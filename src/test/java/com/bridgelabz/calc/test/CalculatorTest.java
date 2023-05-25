package com.bridgelabz.calc.test;


    //adb uninstall io.appium.uiautomator2.server.test

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

    public class CalculatorTest {
        AndroidDriver driver;
        @BeforeClass
        public void createSession() throws MalformedURLException {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName","Google Pixel 2");
            //emulator-5554
            cap.setCapability("platformName","Android");
            cap.setCapability("platformVersion","9.0");
            cap.setCapability("appPackage", "com.android.calculator2");
            cap.setCapability("appActivity","com.android.calculator2.Calculator");

            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
            System.out.println("Calculator launched!!");
        }

        @Test(priority = 0)
        public void handlingPlusCalcOperation(){
            driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
            driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
            driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
            driver.findElement(By.id("com.android.calculator2:id/eq")).click();
            String text = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
            Assert.assertEquals(text,"10", "Plus Operation Successfully Executed!!");
        }
        @Test(priority = 1)
        public void handlingMinusCalcOperation(){
            driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
            driver.findElement(By.id("com.android.calculator2:id/op_sub")).click();
            driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
            driver.findElement(By.id("com.android.calculator2:id/eq")).click();
            String text = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
            Assert.assertEquals(text,"3", "subtraction Operation Successfully Executed!!");
        }
        @Test(priority = 2)
        public void handlingMultiplicationCalcOperation(){
            driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
            driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
            driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
            driver.findElement(By.id("com.android.calculator2:id/eq")).click();
            String text = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
            Assert.assertEquals(text,"10", "multiplication Operation Successfully Executed!!");
        }
        @Test(priority = 3)
        public void handlingDivisionCalcOperation(){
            driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
            driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
            driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
            driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
            driver.findElement(By.id("com.android.calculator2:id/eq")).click();
            String text = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
            Assert.assertEquals(text,"5", "division Operation Successfully Executed!!");
        }


        @AfterClass
        public void tearDown(){
            driver.quit();
        }
    }

