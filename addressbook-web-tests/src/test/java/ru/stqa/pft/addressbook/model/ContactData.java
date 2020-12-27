package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String lastname;
  private final String firstname;
  private final String address;
  private final String email;
  private final String telephoneWork;
  private final String title;
  private final String company;
  private final String group;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(lastname, that.lastname) &&
            Objects.equals(firstname, that.firstname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastname, firstname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            '}';
  }

  public ContactData(String lastname, String firstname, String address, String email, String telephoneWork, String title, String company, String group) {
    this.lastname = lastname;
    this.firstname = firstname;
    this.address = address;
    this.email = email;
    this.telephoneWork = telephoneWork;
    this.title = title;
    this.company = company;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}
