package edu.project.pages;

import edu.project.utils.AndroidActions;
import edu.project.utils.CommonActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloguePage {

  private final AndroidDriver driver;
  private final AndroidActions actions;
  private final CommonActions commonActions;

  public ProductCataloguePage(AndroidDriver driver) {
    this.driver = driver;
    actions = new AndroidActions(driver);
    commonActions = new CommonActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
  private List<WebElement> productNameList;

  @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
  private List<WebElement> productAddToCartButtonList;

  @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
  private WebElement cart;

  public void addItemToCart(String itemName) {
    int index = productNameList.stream().map(WebElement::getText).toList().indexOf(itemName);
    productAddToCartButtonList.get(index).click();
  }

  public void goToCartPage() {
    cart.click();
  }
}
