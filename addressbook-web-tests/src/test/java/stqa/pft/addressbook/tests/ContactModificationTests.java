package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

/**
 * Created by Iwona Zajac on 04.04.2018.
 */
public class ContactModificationTests extends TestBase {

  @Test(enabled = true)
  public void testContactModification() {
    app.goTo().gotoHomePage();
    app.contact().initContactModification();
    app.contact().fillContactForm(new ContactData().withFirstname("test_name")
            .withLastname("test_surname"), false);
    app.contact().submitContactModification();
    app.contact().returnToHomePage();
  }

}