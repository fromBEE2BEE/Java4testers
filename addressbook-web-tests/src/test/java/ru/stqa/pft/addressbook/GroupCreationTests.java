package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation(By.xpath("(//input[@name='new'])[2]"));
    fillGroupForm(new GroupData("testQ1", "testQ2", "testQ3"));
    submitGroupCreation("submit");
    returnToGroupPage("group page");

  }

}
