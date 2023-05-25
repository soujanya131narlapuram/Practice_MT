package com.bridgelabz.calc.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class UploadingAFile {


    AndroidDriver driver;
    WebDriverWait wait;
    String AppURL = "http://cgi-lib.berkeley.edu/ex/fup.html";

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Create an object for Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("autoGrantPermissions",true);





        // Initialize the driver object with the URL to Appium Server and
        // passing the capabilities
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.setFileDetector(new LocalFileDetector());
    }

    @Test
    public void testSearchAppium() throws IOException, InterruptedException {

        //Navigate to app url
        driver.get(AppURL);

        //Click on upload button
        By uploadBtn = By.name("upfile");
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadBtn));
        driver.findElement(uploadBtn).click();

        //Push file to device
//        Thread.sleep(10000);
//        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        Thread.sleep(10000);
        driver.pushFile("/sdcard/Download/test.pdf", new File("C:\\Users\\narla\\IdeaProjects\\Calculator_MobileTesting\\src\\main\\resources\\sample.pdf"));
        Thread.sleep(10000);
        //Switch to Native_App
        Set<String> contextNames = driver.getContextHandles();
        for (String strContextName : contextNames) {
            if (strContextName.contains("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                break;
            }
        }

        //Click on 'Allow' - permission
        By elementView = By.id("com.android.permissioncontroller:id/permission_allow_button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementView));
        driver.findElement(elementView).click();

        //Click on files

        By eleFile = By.xpath("//*[@text='Files']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(eleFile));
        driver.findElement(eleFile).click();

        //select pdf file from downloads (location of pdf file)
        By eleDoc = By.id("com.android.documentsui:id/thumbnail");
        wait.until(ExpectedConditions.visibilityOfElementLocated(eleDoc));
        driver.findElement(eleDoc).click();

        //Switch to Chrome browser
        Set<String> contextNames1 = driver.getContextHandles();
        for (String strContextName : contextNames1) {
            if (strContextName.contains("CHROMIUM")) {
                driver.context("CHROMIUM");
                break;
            }
        }

        //Click on submit button
        WebElement btnElement = driver.findElement(By.cssSelector("input[type=submit]"));
        wait.until(ExpectedConditions.visibilityOf(btnElement));
        btnElement.click();

        //Add a simple assertion
        By nextPageHeader = By.cssSelector("h1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageHeader));
        Assert.assertTrue(driver.findElement(nextPageHeader).getText().equals("File Upload Results"));

    }

    @AfterTest
    public void tearDown() {
        if(driver !=null)
            driver.quit();
    }



}
