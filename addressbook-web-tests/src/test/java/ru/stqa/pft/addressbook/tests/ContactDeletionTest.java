package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {

    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("testQ1", null, null));
        app.getContactHelper().createContact(new ContactData("Zhanna", "Makoviy", "Content Marketing Writer", "Innovecs", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "+38(044)5937794", "marketing@innovecs.com", "testQ1"), true);
        app.getContactHelper().deleteContact();
      } else {
        app.getContactHelper().createContact(new ContactData("Zhanna", "Makoviy", "Content Marketing Writer", "Innovecs", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "+38(044)5937794", "marketing@innovecs.com", "testQ1"), true);
        app.getContactHelper().deleteContact();
        }
      } else {
      int before = app.getContactHelper().getContactCount();
      app.getContactHelper().selectContact(before - 1);
      app.getContactHelper().deleteContact();
      int after = app.getContactHelper().getContactCount();
      Assert.assertEquals(after, before - 1);


    }

  }
}


