package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import static java.lang.Thread.sleep;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void alertContactDeletion() throws InterruptedException {
    acceptAlert();
    sleep(3000);
  }

  public void initDeleteSelectedContact() throws InterruptedException {
    click(By.xpath("//div[2]/input"));
    sleep(2000);
  }

  public void selectContact() throws InterruptedException {
    click(By.xpath("//input[@id]"));
    sleep(2000);
  }

  public void acceptAlert(){
    Alert alert = wd.switchTo().alert();
    alert.accept();
  }

  public void submitNewContactCreation(String s) {
    click(By.xpath(s));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("work"), contactData.getTelephoneWork());
    type(By.name("email"), contactData.getEmail());
  }

  public void initEditSelectedContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.cssSelector("input[name=\"update\"]"));
  }
}
