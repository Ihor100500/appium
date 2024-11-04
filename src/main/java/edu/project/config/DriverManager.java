package edu.project.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static edu.project.config.AppiumConfig.createService;

public class DriverManager {

  private AndroidDriver androidDriver;
  private static DriverManager instance;

  private DriverManager() {
  }

  public static DriverManager getInstance() {
    if (instance == null) {
      instance = new DriverManager();
    }
    return instance;
  }

  public void setUp() {
    try {
      androidDriver = DriverConfig.createDriver();
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  public void quitDriver() {
    if (androidDriver != null) {
      androidDriver.quit();
    }
  }

  public AndroidDriver getDriver() {
    return androidDriver;
  }


}
