package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewContactCreationTests {
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php?new=New+group");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testNewContactCreation() throws Exception {
    initNewContactCteation();
    fillNewContactForm("Zhanna", "Makoviy", "Content Marketing Writer", "Innovecs", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "+38(044)5937794", "marketing@innovecs.com", "new_group");
    submitNewContactCreation("(//input[@name='submit'])[2]");
    returnToHomePage("home page");
  }

  private void returnToHomePage(String s) {
    wd.findElement(By.linkText(s)).click();
  }

  private void submitNewContactCreation(String s) {
    wd.findElement(By.xpath(s)).click();
  }

  private void fillNewContactForm(String firstname, String lastname, String title, String company, String address, String telephoneWork, String email, String contactGroup) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).sendKeys(firstname);
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).sendKeys(lastname);
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).sendKeys(title);
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).sendKeys(company);
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).sendKeys(address);
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).sendKeys(telephoneWork);
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).sendKeys(email);
    wd.findElement(By.name("new_group")).click();
    new Select(wd.findElement(By.name(contactGroup))).selectByVisibleText("testQ1");
  }

  private void initNewContactCteation() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    logout("Logout");
    wd.quit();

  }

  private void logout(String logout) {
    wd.findElement(By.linkText(logout)).click();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
