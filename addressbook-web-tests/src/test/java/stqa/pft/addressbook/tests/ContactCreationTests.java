package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

/**
 * Created by Iwona Zajac on 04.04.2018.
 */
public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().gotoHomePage();
    app.contact().initContactCreation();
    app.contact().fillContactForm(new ContactData().withFirstname("test_name").withLastname("test_surname")
            .withGroup("test1").withPhone("+7 (111)").withMobilePhone("22-22").withWorkPhone("33 33 33"), true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
  }
}
