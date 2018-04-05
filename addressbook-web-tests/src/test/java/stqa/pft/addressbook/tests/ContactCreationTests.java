package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

/**
 * Created by Iwona Zajac on 04.04.2018.
 */
public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("test_name","test_surname","test1"),true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
