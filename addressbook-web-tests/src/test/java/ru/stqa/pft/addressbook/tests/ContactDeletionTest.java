package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws InterruptedException {

    app.getContactHelper().selectContactForDeletion();
    app.getContactHelper().initDeleteSelectedContact();
    app.getContactHelper().alertContactDeletion();
  }


}
