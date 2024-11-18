package edu.project.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions {

  private AndroidDriver driver;

  public AndroidActions(AndroidDriver driver) {
    this.driver = driver;
  }

  public void performLongPressAction(WebElement element) {
    ((JavascriptExecutor) driver)
        .executeScript(
            "mobile: longClickGesture",
            ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
  }

  public void performSwipeAction(WebElement element, String direction) {
    ((JavascriptExecutor) driver)
        .executeScript(
            "mobile: swipeGesture",
            ImmutableMap.of(
                "elementId",
                ((RemoteWebElement) element).getId(),
                "direction",
                direction,
                "percent",
                0.25));
  }

  public Boolean performSlowScrollAction() {
    return (Boolean)
        ((JavascriptExecutor) driver)
            .executeScript(
                "mobile: scrollGesture",
                ImmutableMap.of(
                    "left",
                    100,
                    "top",
                    100,
                    "width",
                    200,
                    "height",
                    200,
                    "direction",
                    "down",
                    "percent",
                    3.0));
  }

  public void performDragAndDropAction(WebElement element, int endX, int endY) {
    ((JavascriptExecutor) driver)
        .executeScript(
            "mobile: dragGesture",
            ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY));
  }

  public By scrollToText(String elementName) {
    String uiAutomatorText =
        String.format(
            "new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"))", elementName);
    return AppiumBy.androidUIAutomator(uiAutomatorText);
  }
}
