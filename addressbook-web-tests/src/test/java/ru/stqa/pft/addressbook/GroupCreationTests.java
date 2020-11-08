package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    login("user", "pass", By.xpath("//input[@value='Login']"), "admin", "secret");
  }

  private void login(String user, String pass, By xpath, String username, String password) {
    wd.findElement(By.name(user)).clear();
    wd.findElement(By.name(user)).sendKeys(username);
    initGroupCreation(By.name(pass));
    wd.findElement(By.name(pass)).clear();
    wd.findElement(By.name(pass)).sendKeys(password);
    wd.findElement(xpath).click();
  }

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation(By.xpath("(//input[@name='new'])[2]"));
    fillGroupForm(new GroupData("testQ1", "testQ2", "testQ3"));
    submitGroupCreation("submit");
    returnToGroupPage("group page");

  }

  private void returnToGroupPage(String s) {
    wd.findElement(By.linkText(s)).click();
  }

  private void submitGroupCreation(String submit) {
    wd.findElement(By.name(submit)).click();
  }

  private void fillGroupForm(GroupData groupData) {
    submitGroupCreation("group_name");
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void initGroupCreation(By xpath) {
    wd.findElement(xpath).click();
  }

  private void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    logout();
    wd.quit();

  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
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
