package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {
  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage(String s) {
    click(By.linkText(s));
  }

  public void submitGroupCreation(String submit) {
    click(By.name(submit));

  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation(By xpath) {
    click(xpath);
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(String s) {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation(By.xpath("(//input[@name='new'])[2]"));
    fillGroupForm(group);
    submitGroupCreation("submit");
    returnToGroupPage("group page");
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }
}
