package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class ContactHelper {


  private FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void alertContactDeletion() throws InterruptedException {
    acceptAlert();
    sleep(3000);
  }

  public void initDeleteSelectedContact() throws InterruptedException {
    wd.findElement(By.xpath("//div[2]/input")).click();
    sleep(2000);
  }

  public void selectContactForDeletion() throws InterruptedException {
    wd.findElement(By.xpath("//input[@id]")).click();
    sleep(2000);
  }

  public void acceptAlert(){
    Alert alert = wd.switchTo().alert();
    alert.accept();
  }
}
