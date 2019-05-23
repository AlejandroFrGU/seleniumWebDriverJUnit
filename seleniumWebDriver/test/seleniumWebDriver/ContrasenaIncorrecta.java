package seleniumWebDriver;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class ContrasenaIncorrecta {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
    driver = new HtmlUnitDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testContrasenaIncorrecta() throws Exception {
    driver.get("https://loginejemplo2.azurewebsites.net/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Register'])[1]/following::a[1]")).click();
    driver.findElement(By.id("Input_Email")).click();
    driver.findElement(By.id("Input_Email")).clear();
    driver.findElement(By.id("Input_Email")).sendKeys("patata@hotmail.com");
    driver.findElement(By.id("Input_Password")).clear();
    driver.findElement(By.id("Input_Password")).sendKeys("P4tata_");
    driver.findElement(By.id("account")).submit();
    driver.findElement(By.linkText("Hello patata@hotmail.com!")).click();
    driver.findElement(By.id("change-password")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirm new password'])[1]/following::button[1]")).click();
    driver.findElement(By.id("Input_OldPassword")).clear();
    driver.findElement(By.id("Input_OldPassword")).sendKeys("patata");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirm new password'])[1]/following::button[1]")).click();
    driver.findElement(By.id("Input_NewPassword")).click();
    driver.findElement(By.id("Input_NewPassword")).clear();
    driver.findElement(By.id("Input_NewPassword")).sendKeys("patata");
    driver.findElement(By.id("change-password-form")).click();
    driver.findElement(By.id("Input_OldPassword")).click();
    driver.findElement(By.id("Input_OldPassword")).clear();
    driver.findElement(By.id("Input_OldPassword")).sendKeys("");
    driver.findElement(By.id("Input_ConfirmPassword")).click();
    driver.findElement(By.id("Input_ConfirmPassword")).clear();
    driver.findElement(By.id("Input_ConfirmPassword")).sendKeys("patata");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirm new password'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change password'])[1]/following::div[2]")).click();
    driver.findElement(By.id("Input_NewPassword")).clear();
    driver.findElement(By.id("Input_NewPassword")).sendKeys("");
    driver.findElement(By.id("change-password-form")).click();
    driver.findElement(By.id("Input_OldPassword")).click();
    driver.findElement(By.id("Input_OldPassword")).clear();
    driver.findElement(By.id("Input_OldPassword")).sendKeys("patata");
    driver.findElement(By.id("Input_NewPassword")).click();
    driver.findElement(By.id("Input_NewPassword")).clear();
    driver.findElement(By.id("Input_NewPassword")).sendKeys("patata");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Logout'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirm new password'])[1]/following::button[1]")).click();
    driver.findElement(By.id("Input_OldPassword")).click();
    driver.findElement(By.id("Input_OldPassword")).clear();
    driver.findElement(By.id("Input_OldPassword")).sendKeys("P4tata_");
    driver.findElement(By.id("Input_NewPassword")).clear();
    driver.findElement(By.id("Input_NewPassword")).sendKeys("patata");
    driver.findElement(By.id("Input_ConfirmPassword")).clear();
    driver.findElement(By.id("Input_ConfirmPassword")).sendKeys("patata");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirm new password'])[1]/following::button[1]")).click();
    driver.findElement(By.id("Input_OldPassword")).click();
    driver.findElement(By.id("Input_OldPassword")).clear();
    driver.findElement(By.id("Input_OldPassword")).sendKeys("P4tata_");
    driver.findElement(By.id("Input_NewPassword")).clear();
    driver.findElement(By.id("Input_NewPassword")).sendKeys("Patata");
    driver.findElement(By.id("Input_ConfirmPassword")).clear();
    driver.findElement(By.id("Input_ConfirmPassword")).sendKeys("Patata");
    driver.findElement(By.id("change-password-form")).submit();
    driver.findElement(By.id("Input_OldPassword")).click();
    driver.findElement(By.id("Input_OldPassword")).clear();
    driver.findElement(By.id("Input_OldPassword")).sendKeys("P4tata_");
    driver.findElement(By.id("Input_NewPassword")).clear();
    driver.findElement(By.id("Input_NewPassword")).sendKeys("P4tata");
    driver.findElement(By.id("Input_ConfirmPassword")).clear();
    driver.findElement(By.id("Input_ConfirmPassword")).sendKeys("P4tata");
    driver.findElement(By.id("change-password-form")).submit();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hello patata@hotmail.com!'])[1]/following::button[1]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}