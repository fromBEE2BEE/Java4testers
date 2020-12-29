package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String lastname;
  private final String firstname;
  private final String address;
  private final String email;
  private final String telephoneWork;
  private final String title;
  private final String company;
  private final String group;

  public ContactData(String lastname, String firstname, String address, String email, String telephoneWork, String title, String company, String group) {
    this.id = null;
    this.lastname = lastname;
    this.firstname = firstname;
    this.address = address;
    this.email = email;
    this.telephoneWork = telephoneWork;
    this.title = title;
    this.company = company;
    this.group = group;
  }
  public ContactData(String id, String lastname, String firstname, String address, String email, String telephoneWork, String title, String company, String group) {
    this.id = id;
    this.lastname = lastname;
    this.firstname = firstname;
    this.address = address;
    this.email = email;
    this.telephoneWork = telephoneWork;
    this.title = title;
    this.company = company;
    this.group = group;
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(firstname, that.firstname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastname, firstname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            '}';
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
