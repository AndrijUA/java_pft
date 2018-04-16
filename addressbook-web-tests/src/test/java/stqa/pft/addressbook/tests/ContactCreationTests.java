package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Groups;

import java.io.File;

/**
 * Created by Iwona Zajac on 04.04.2018.
 */
public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/czlowiek.jpg");
    ContactData newContact = new ContactData().withFirstname("test_name").withLastname("test_surname")
            .withPhone("+7 (111)").withMobilePhone("22-22").withWorkPhone("33 33 33")
            .withPhoto(photo).inGroup(groups.iterator().next());
    app.goTo().gotoHomePage();
    app.contact().initContactCreation();
    app.contact().fillContactForm(newContact, true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
  }

  //sprawdzenie jaka dyrektoria jest korniewaja
  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/czlowiek.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
