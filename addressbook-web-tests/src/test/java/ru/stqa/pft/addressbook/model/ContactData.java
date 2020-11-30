package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String title;
  private final String company;
  private final String address;
  private final String telephoneWork;
  private final String email;
  private final String contactGroup;

  public ContactData(String firstname, String lastname, String title, String company, String address, String telephoneWork, String email, String contactGroup) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.telephoneWork = telephoneWork;
    this.email = email;
    this.contactGroup = contactGroup;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getTelephoneWork() {
    return telephoneWork;
  }

  public String getEmail() {
    return email;
  }

  public String getContactGroup() {
    return contactGroup;
  }
}
