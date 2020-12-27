package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.List;
import java.util.Arrays;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebElement;


public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {

    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("testQ1", null, null));
        app.getContactHelper().createContact(new ContactData("Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", "testQ1"), true);
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

      } else {
        app.getContactHelper().createContact(new ContactData("Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", "testQ1"), true);
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

        }
      } else {
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size() - 1);
      app.getContactHelper().deleteContact();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(before.size() - 1);
      Assert.assertEquals(before, after);


    }
  }
}


