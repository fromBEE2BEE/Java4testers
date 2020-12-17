package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("testQ1", null, null));
    }
    app.getGroupHelper().selectGroup("selected[]");
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("testQ1", "testQ2", "testQ3"));
    app.getGroupHelper().submitGroupModification();
    app.returnToGroupPage();
  }
}
