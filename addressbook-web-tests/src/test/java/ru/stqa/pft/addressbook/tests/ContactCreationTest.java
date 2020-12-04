package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.getContactHelper().fillNewContactForm(new ContactData("Zhanna", "Makoviy", "Content Marketing Writer", "Innovecs", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "+38(044)5937794", "marketing@innovecs.com", "new_group"));
    app.getContactHelper().submitNewContactCreation("(//input[@name='submit'])[2]");
    app.returnToHomePage("home page");
  }


}
