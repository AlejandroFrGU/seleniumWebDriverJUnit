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

public class ContrasenaIncorrectaVacios {
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
  public void testContrasenaIncorrecta1() throws Exception {
    driver.get("https://loginejemplo2.azurewebsites.net/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Register'])[1]/following::a[1]")).click();
    driver.findElement(By.id("Input_Email")).click();
    driver.findElement(By.id("Input_Email")).clear();
    driver.findElement(By.id("Input_Email")).sendKeys("prueba@hotmail.com");
    driver.findElement(By.id("Input_Password")).click();
    driver.findElement(By.id("Input_Password")).clear();
    driver.findElement(By.id("Input_Password")).sendKeys("L4pas_");
    driver.findElement(By.id("account")).submit();
    driver.findElement(By.linkText("Hello prueba@hotmail.com!")).click();
    driver.findElement(By.id("change-password")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirm new password'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change password'])[1]/following::li[1]")).click();
    assertEquals("The Current password field is required.", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change password'])[1]/following::li[1]")).getText());
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='The Current password field is required.'])[1]/following::li[1]")).click();
    assertEquals("The New password field is required.", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='The Current password field is required.'])[1]/following::li[1]")).getText());
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hello prueba@hotmail.com!'])[1]/following::button[1]")).click();
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
