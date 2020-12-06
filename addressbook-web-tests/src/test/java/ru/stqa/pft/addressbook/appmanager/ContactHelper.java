package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void alertContactDeletion() {
    acceptAlert();
    wd.findElementByCssSelector("div.msgbox");
  }

  public void initDeleteSelectedContact() {
    click(By.xpath("//div[2]/input"));
  }

  public void selectContact() {
    click(By.xpath("//input[@id]"));
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
