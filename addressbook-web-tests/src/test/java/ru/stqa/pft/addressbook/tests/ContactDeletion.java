package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactDeletion {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");

  }

  private void login(String username, String password) {
    wd.findElement(By.cssSelector("input[name=\"user\"]")).click();
    wd.findElement(By.cssSelector("input[name=\"user\"]")).clear();
    wd.findElement(By.cssSelector("input[name=\"user\"]")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactDeletionTests() throws Exception {

    selectContactForDeletion();
    initDeleteSelectedContact();
    alertContactDeletion();
  }

  private void alertContactDeletion() throws InterruptedException {
    acceptAlert();
    Thread.sleep(3000);
  }

  private void initDeleteSelectedContact() throws InterruptedException {
    wd.findElement(By.xpath("//div[2]/input")).click();
    Thread.sleep(2000);
  }

  private void selectContactForDeletion() throws InterruptedException {
    wd.findElement(By.xpath("//input[@id]")).click();
    Thread.sleep(2000);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    logout("Logout");
    wd.quit();
    }

  public void acceptAlert(){
    Alert alert = wd.switchTo().alert();
    alert.accept();
  }



  private void logout(String logout) {
    wd.findElement(By.linkText(logout)).click();
  }


  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
