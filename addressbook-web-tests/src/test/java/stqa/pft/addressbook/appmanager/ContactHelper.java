package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stqa.pft.addressbook.model.ContactData;

/**
 * Created by Iwona Zajac on 04.04.2018.
 */
public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    //click(By.name("add new"));
    click(By.linkText("add new"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

//  public void submitContactCreation() {
//    click(By.name("submit"));
//  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

//  public void returnToHomePage() {
//    click(By.linkText("home page"));
//  }


//  public void initContactModification() {
//    click(By.cssSelector("//img[@alt='Edit']"));
//  }

  public void initContactModification() {
    click(By.cssSelector("img[alt='Edit']"));
  }


  public void submitContactModification() {
    click(By.name("update"));
  }

//  public void submitContactModification() {
//    click(By.name("update"));
//  }

}
