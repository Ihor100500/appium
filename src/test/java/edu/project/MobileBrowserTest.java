package edu.project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BaseTest {

  @Test
  public void openBrowserTest() throws InterruptedException {
    driver.get("https://google.com");
    fluentWait()
        .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Więcej opcji']"))));
    WebElement element = driver.findElement(By.xpath("//div[text()='Więcej opcji']"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    Thread.sleep(2000); // co to kurwa jest???????? think how to avoid it, waiting for what?????
    driver.findElement(By.xpath("//div[text()='Odrzuć wszystko']")).click();
    driver.findElement(By.name("q")).sendKeys("Bober Kurwa");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
  }
}
