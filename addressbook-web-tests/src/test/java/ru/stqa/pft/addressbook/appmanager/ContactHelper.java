package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

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

  public void submitNewContactCreation(String s) {
    wd.findElement(By.xpath(s)).click();
  }

  public void fillNewContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).sendKeys(contactData.getTelephoneWork());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    wd.findElement(By.name("new_group")).click();
    new Select(wd.findElement(By.name(contactData.getContactGroup()))).selectByVisibleText("testQ1");
  }
}
