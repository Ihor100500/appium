package edu.project.pages;

import edu.project.constants.Gender;
import edu.project.utils.AndroidActions;
import edu.project.utils.CommonActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

import static edu.project.constants.Gender.FEMALE;

public class FormPage {

  private final AndroidDriver driver;
  private final AndroidActions actions;
  private final CommonActions commonActions;

  public FormPage(AndroidDriver driver) {
    this.driver = driver;
    actions = new AndroidActions(driver);
    commonActions = new CommonActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
  private WebElement nameField;

  @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
  private WebElement femaleOption;

  @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
  private WebElement maleOption;

  @AndroidFindBy(id = "android:id/text1")
  private WebElement countrySelection;

  @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
  private WebElement shopButton;

  public void setNameField(String name) {
    commonActions.waitAndType(nameField, name);
    driver.hideKeyboard();
  }

  public void setGender(Gender gender) {
    if (Objects.equals(gender, FEMALE)) {
      femaleOption.click();
    } else {
      maleOption.click();
    }
  }

  public void setCountrySelection(String countryName) {
    countrySelection.click();
    By countryToSelectLocator = actions.scrollToText(countryName);
    driver.findElement(countryToSelectLocator).click();
  }

  public void submitForm(){
    shopButton.click();
  }
}
