package edu.project;

import com.google.common.collect.ImmutableMap;
import edu.project.constants.Gender;
import edu.project.pages.FormPage;
import edu.project.pages.ProductCataloguePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static edu.project.constants.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class GeneralStoreTest extends BaseTest {

  @Test
  public void fillFormTest() {
    FormPage formPage = new FormPage(driver);
    ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);
    formPage.setNameField("Bober Kurwa");
    formPage.setGender(MALE);
    formPage.setCountrySelection("Argentina");
    formPage.submitForm();
    productCataloguePage.addItemToCart("Jordan 6 Rings");
    productCataloguePage.goToCartPage();
    //wait for cart page to be displayed
  }

//  @Test
//  public void toastMessageTest() {
//    nameField.sendKeys("");
//    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//    fluentWait().until(presenceOfElementLocated(AppiumBy.xpath("//android.widget.Toast")));
//    String errorMessage =
//        driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");
//    assertThat(errorMessage).isEqualTo("Please enter your name");
//  }
//
//  @Test
//  public void addItemToCartTest() {
//    fillFormTest();
//    By jordanLocator = scrollToElement("Jordan 6 Rings");
//    driver.findElement(jordanLocator);
//
//    List<WebElement> elements =
//        driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"));
//    int index = elements.stream().map(WebElement::getText).toList().indexOf("Jordan 6 Rings");
//    driver
//        .findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart"))
//        .get(index)
//        .click();
//    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//    WebElement cartTitle =
//        fluentWait()
//            .until(
//                presenceOfElementLocated(
//                    AppiumBy.xpath("//android.widget.TextView[@text='Cart']")));
//    assertThat(cartTitle.getText()).isEqualTo("Cart");
//    String productName =
//        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
//    //    assertThat(productName).isEqualTo("Jordan 6 Rings");
//  }
//
//  @Test
//  public void numberOfProductsAddedTest() {
//    fillFormTest();
//    fluentWait()
//        .until(
//            presenceOfElementLocated(
//                AppiumBy.xpath("//android.widget.TextView[@text='Products']")));
//    List<WebElement> elements =
//        driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart"));
//    elements.forEach(WebElement::click);
//    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//    fluentWait()
//        .until(presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Cart']")));
//    List<WebElement> elementsInCart =
//        driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
//    assertThat(elementsInCart.size()).isEqualTo(elements.size());
//
//    Double expectedSum =
//        elementsInCart.stream()
//            .map(WebElement::getText)
//            .map(price -> price.substring(1))
//            .map(Double::valueOf)
//            .reduce(0.0, Double::sum);
//
//    String totalValue =
//        driver
//            .findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl"))
//            .getText();
//    Double actualSum = Double.valueOf(totalValue.substring(2));
//
//    assertThat(actualSum).isEqualTo(expectedSum);
//  }
//
//  @Test
//  public void longPressTest() {
//    fillFormTest();
//    By jordanLocator = scrollToElement("Jordan 6 Rings");
//    driver.findElement(jordanLocator);
//
//    List<WebElement> elements =
//        driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"));
//    int index = elements.stream().map(WebElement::getText).toList().indexOf("Jordan 6 Rings");
//    driver
//        .findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart"))
//        .get(index)
//        .click();
//    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//    WebElement cartTitle =
//        fluentWait()
//            .until(
//                presenceOfElementLocated(
//                    AppiumBy.xpath("//android.widget.TextView[@text='Cart']")));
//    assertThat(cartTitle.getText()).isEqualTo("Cart");
//
//    WebElement element =
//        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
//    performLongPressAction(element);
//
//    fluentWait()
//        .until(
//            attributeToBe(
//                AppiumBy.id("com.androidsample.generalstore:id/alertTitle"),
//                "text",
//                "Terms Of Conditions"));
//
//    String termsOfConditions = driver.findElement(AppiumBy.id("android:id/message")).getText();
//    assertThat(termsOfConditions).contains("Lorem Ipsum is simply dummy text");
//  }
//
//  @Test
//  public void hybridModeTest() throws InterruptedException {
//    addItemToCartTest();
//    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
//    // switch to web context
//    //    driver.getContextHandles(); // returns all existing contexts: native and web
//
//    while (driver.getContextHandles().size() == 1) {
//      Thread.sleep(500);
//    }
//    driver.context("WEBVIEW_com.androidsample.generalstore");
//
//    WebElement element = driver.findElement(By.xpath("//div[text()='Więcej opcji']"));
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].scrollIntoView(true);", element);
//    fluentWait()
//        .until(
//            ExpectedConditions.visibilityOf(
//                driver.findElement(By.xpath("//div[text()='Odrzuć wszystko']"))));
//    Thread.sleep(2000); // co to kurwa jest???????? think how to avoid it, waiting for what?????
//    driver.findElement(By.xpath("//div[text()='Odrzuć wszystko']")).click();
//    driver.findElement(By.name("q")).sendKeys("Bober Kurwa");
//    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//    driver.pressKey(new KeyEvent(AndroidKey.BACK));
//    driver.context("NATIVE_APP");
//    fluentWait()
//        .until(
//            ExpectedConditions.attributeToBe(
//                AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"),
//                "text",
//                "General Store"));
//  }
}
