package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {

    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("testQ1", null, null));
        app.getContactHelper().createContact(new ContactData("Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", "testQ1"), true);
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", null);
        app.getContactHelper().modificateContact(new ContactData(null, "Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", null), false);
        app.getNavigationHelper().returnToHomePage("home page");
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
      } else {
        app.getContactHelper().createContact(new ContactData("Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", "testQ1"), true);
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", null);
        app.getContactHelper().modificateContact(new ContactData(null, "Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", null), false);
        app.getNavigationHelper().returnToHomePage("home page");
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
      }
    } else {
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size() - 1);
      ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", null);
      app.getContactHelper().modificateContact(new ContactData(null, "Makoviy", "Zhanna", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "marketing@innovecs.com", "+38(044)5937794", "Content Marketing Writer", "Innovecs", null), false);
      app.getNavigationHelper().returnToHomePage("home page");
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());
      before.remove(before.size() - 1);
      before.add(contact);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
  }
}
