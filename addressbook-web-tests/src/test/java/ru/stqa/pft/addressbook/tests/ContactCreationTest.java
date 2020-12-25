package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    int before = app.getContactHelper().getContactCount();

    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("testQ1", null, null));
    }
    app.getContactHelper().createContact(new ContactData("Zhanna", "Makoviy", "Content Marketing Writer", "Innovecs", "Kyiv, blvr Vatslava Gavela, 6 \"3\"", "+38(044)5937794", "marketing@innovecs.com", "testQ1"), true);

    int after = app.getContactHelper().getContactCount();

    Assert.assertEquals(after, before + 1);

  }
}
