package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import java.io.File;

/**
 * Created by Iwona Zajac on 04.04.2018.
 */
public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().gotoHomePage();
    app.contact().initContactCreation();
    File photo = new File("src/test/resources/czlowiek.jpg");
    app.contact().fillContactForm(new ContactData().withFirstname("test_name").withLastname("test_surname")
            .withGroup("test1").withPhone("+7 (111)").withMobilePhone("22-22").withWorkPhone("33 33 33")
            .withPhoto(photo), true);
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
