package edu.project.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import static edu.project.utils.WaitUtils.waitForElementToBeClickable;

public class CommonActions {

  private final AndroidDriver driver;

  public CommonActions(AndroidDriver driver){
    this.driver = driver;
  }

  public void waitAndClick(WebElement element){
      waitForElementToBeClickable(driver, element).click();
  }

  public void waitAndType(WebElement field, String text){
    waitForElementToBeClickable(driver, field).sendKeys(text);
  }
}
