package edu.project.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverConfig {

  public static AndroidDriver createDriver() throws MalformedURLException {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setDeviceName("Pixel 3a API 35");
    options.setApp("C:\\Users\\ihor.popov2\\IdeaProjects\\appium-test-project\\src\\test\\resources\\ApiDemos-debug.apk");

    return new AndroidDriver(
        URI.create("http://127.0.0.1:4723/").toURL(),
        options
    );
  }
}
