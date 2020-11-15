package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;
  private GroupHelper groupHelper;

  public boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    login("user", "pass", By.xpath("//input[@value='Login']"), "admin", "secret");
  }

  private void login(String user, String pass, By xpath, String username, String password) {
    wd.findElement(By.name(user)).clear();
    wd.findElement(By.name(user)).sendKeys(username);
    groupHelper.initGroupCreation(By.name(pass));
    wd.findElement(By.name(pass)).clear();
    wd.findElement(By.name(pass)).sendKeys(password);
    groupHelper.initGroupCreation(xpath);
  }

  public void gotoGroupPage() {
    groupHelper.initGroupCreation(By.linkText("groups"));
  }

  public void stop() {
    wd.manage().timeouts().implicitlyWait(350, TimeUnit.SECONDS);
    logout();
    wd.quit();
  }

  private void logout() {
    groupHelper.initGroupCreation(By.linkText("Logout"));
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


  public void returnToGroupPage() {
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
