package edu.project.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverConfig {

  public static AndroidDriver createDriver() throws MalformedURLException {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setDeviceName("Pixel 3a API 35");
    // ToDo implement availability to set device name and app as parameters
    // ToDo implement availability to create driver for hybrid/narive app or just a broswer on mobile
    // options.setApp("C:\\Users\\ihor.popov2\\IdeaProjects\\appium-test-project\\src\\test\\resources\\ApiDemos-debug.apk");
//    options.setApp("C:\\Users\\ihor.popov2\\IdeaProjects\\appium-test-project\\src\\test\\resources\\General-Store.apk");
    options.setChromedriverExecutable("C:\\Users\\ihor.popov2\\IdeaProjects\\appium-test-project\\src\\test\\resources\\chromedriver.exe");
    options.setCapability("browserName", "Chrome");

    return new AndroidDriver(
        URI.create("http://127.0.0.1:4723/").toURL(),
        options
    );
  }
}
