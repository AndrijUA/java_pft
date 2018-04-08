package stqa.pft.addressbook.model;

/**
 * Created by Iwona Zajac on 04.04.2018.
 */
public class ContactData {

  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String secondname;
  private String group;
  private String home;
  private String mobile;
  private String work;

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return secondname;
  }

  public String getGroup() {
    return group;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String secondname) {
    this.secondname = secondname;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withPhone(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobilePhone(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWorkPhone(String work) {
    this.work = work;
    return this;
  }
}
