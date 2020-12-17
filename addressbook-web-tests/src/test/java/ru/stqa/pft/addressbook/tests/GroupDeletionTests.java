package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {

    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("testQ1", null, null));
    }
    app.getGroupHelper().selectGroup("selected[]");
    app.getGroupHelper().deleteSelectedGroups();
    app.returnToGroupPage();

  }

}
