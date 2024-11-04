package edu.project;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AppiumBasicsTest extends BaseTest {

  @Test
  public void wifiSettingTest() {
    driver.findElement(AppiumBy.accessibilityId("Preference")).click();
    driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
    driver.findElement(AppiumBy.id("android:id/checkbox")).click();
    driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
    String alertTitleText = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
    assertThat(alertTitleText).isEqualTo("WiFi settings");
    driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("BoberKurwa");
    driver.findElement(AppiumBy.id("android:id/button1")).click();
  }

  @Test
  public void longPressGestureTest() {
    driver.findElement(AppiumBy.accessibilityId("Views")).click();
    driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
    driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
    // long press
    WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
    performLongPressAction(element);
    WebElement menuTitle = fluentWait().until(presenceOfElementLocated(By.id("android:id/title")));
    assertThat(menuTitle.getText()).isEqualTo("Sample menu");
  }

  @Test
  public void scrollGestureTest() {
    driver.findElement(AppiumBy.accessibilityId("Views")).click();
    //  if element is known UIAutomator method can be used
//    By webViewLocator = scrollToElement("WebView");
//    driver.findElement(webViewLocator).click();

    // scrolling by a bit until the end of page or any other condition
    boolean canScrollMore;
    do {
      canScrollMore = performSlowScrollAction();
    } while (canScrollMore);
  }

  @Test
  public void swipeGestureTest() {
    driver.findElement(AppiumBy.accessibilityId("Views")).click();
    driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
    driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();

    WebElement firstPhoto = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
    String focusable = firstPhoto.getAttribute("focusable");
    assertThat(focusable).isEqualTo("true"); // boolean??

    performSwipeAction(firstPhoto, "left"); // 4 images, percent is 0.25

    focusable = firstPhoto.getAttribute("focusable");
    assertThat(focusable).isEqualTo("false"); // boolean??
  }

  @Test
  public void dragAndDropGestureTest(){
    driver.findElement(AppiumBy.accessibilityId("Views")).click();
    driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
    WebElement dragSource = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

    performDragAndDropAction(dragSource, 630, 584);

    String text = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
    assertThat(text).isEqualTo("Dropped!");
  }

  @Test
  public void miscellaneousActionsTest(){
    driver.findElement(AppiumBy.accessibilityId("Preference")).click();
    driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
    driver.findElement(AppiumBy.id("android:id/checkbox")).click();

//    DeviceRotation landscapeMode = new DeviceRotation(0,0,90);
//    either through rotation object or method below
//    driver.rotate(landscapeMode);
    driver.rotate(ScreenOrientation.LANDSCAPE);

    driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
    String alertTitleText = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
    assertThat(alertTitleText).isEqualTo("WiFi settings");

    driver.setClipboardText("BoberKurwa");

    driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
    driver.pressKey(new KeyEvent(AndroidKey.ENTER));

    driver.findElement(AppiumBy.id("android:id/button1")).click();
    driver.rotate(ScreenOrientation.PORTRAIT);

    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    driver.pressKey(new KeyEvent(AndroidKey.HOME));
  }

  @Test
  public void openParticularAppPageTest(){
    // package and activity names
    ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
        "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
    ));
    driver.findElement(AppiumBy.id("android:id/checkbox")).click();
    driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
    String alertTitleText = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
    assertThat(alertTitleText).isEqualTo("WiFi settings");
  }
}

