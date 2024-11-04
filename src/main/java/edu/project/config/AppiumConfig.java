package edu.project.config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumConfig {

  private static final File mainJsFile =
      new File("C:\\Users\\ihor.popov2\\AppData\\Roaming\\nvm\\v20.8.0\\node_modules\\appium\\build\\lib\\main.js");

  public static AppiumDriverLocalService createService() {
    return new AppiumServiceBuilder()
        .withAppiumJS(mainJsFile)
        .withIPAddress("127.0.0.1")
        .usingPort(4723)
        .build();
  }
}
