package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void alertContactDeletion() {
    acceptAlert();

    wd.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

  }

  public void initDeleteSelectedContact() {
    click(By.xpath("//div[2]/input"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void acceptAlert(){
    Alert alert = wd.switchTo().alert();
    alert.accept();
  }

  public void submitNewContactCreation(String s) {
    click(By.xpath(s));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("work"), contactData.getTelephoneWork());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initEditSelectedContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.cssSelector("input[name=\"update\"]"));
  }

  public void createContact(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(new ContactData("Zhanna", "Makoviy", "Content Marketing Writer", "Innovecs", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "+38(044)5937794", "marketing@innovecs.com", "testQ1"), true);
    submitNewContactCreation("(//input[@name='submit'])[2]");
    returnToHomePage("home page");
  }

  private void returnToHomePage(String home_page) {
    click(By.linkText("home page"));
  }

  private void initContactCreation() {
    click(By.linkText("add new"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }
  public void deleteContact() {

    initDeleteSelectedContact();
    alertContactDeletion();
  }
  public void modificateContact() {

    initEditSelectedContact();
    fillContactForm(new ContactData("Zhanna", "Makoviy", "Content Marketing Writer", "Innovecs", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "+38(044)5937794", "marketing@innovecs.com", null), false);
    submitContactModification();
  }


  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
