package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("testQ1", null, null));

    }
    int before = app.getGroupHelper().getGroupCount();
    // удаление 1-го элемента:
    //app.getGroupHelper().selectGroup(0);
    // удаление последнего элемента:
    app.getGroupHelper().selectGroup(before - 1);
    //app.getGroupHelper().selectGroup("selected[]");
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before -1);
  }
}
