package edu.project;

import com.google.common.collect.ImmutableMap;
import edu.project.config.AppiumManager;
import edu.project.config.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
  protected AndroidDriver driver;

  @BeforeClass
  public void setupService() {
    AppiumManager.getInstance().startService();
  }

  @BeforeMethod
  public void setupDriver() {
    DriverManager.getInstance().setUp();
    driver = DriverManager.getInstance().getDriver();
  }

  @AfterMethod
  public void quit() {
    DriverManager.getInstance().quitDriver();
  }

  @AfterClass
  public void tearDown() {
    AppiumManager.getInstance().stopService();
  }



  public Wait<AndroidDriver> fluentWait() {
    return new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(5))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(NoSuchElementException.class);
  }


}
