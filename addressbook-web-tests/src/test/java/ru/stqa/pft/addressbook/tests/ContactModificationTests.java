package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initEditSelectedContact();
    app.getContactHelper().fillContactForm(new ContactData("Zhanna", "Makoviy", "Content Marketing Writer", "Innovecs", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "+38(044)5937794", "marketing@innovecs.com"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage("home page");
  }
}
