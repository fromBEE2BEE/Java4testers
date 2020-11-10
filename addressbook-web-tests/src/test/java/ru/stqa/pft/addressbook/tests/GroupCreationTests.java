package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation(By.xpath("(//input[@name='new'])[2]"));
    app.fillGroupForm(new GroupData("testQ1", "testQ2", "testQ3"));
    app.submitGroupCreation("submit");
    app.returnToGroupPage("group page");

  }

}
