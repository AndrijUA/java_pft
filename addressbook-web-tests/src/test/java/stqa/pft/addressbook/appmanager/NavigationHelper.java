package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Iwona Zajac on 02.04.2018.
 */
public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    click(By.linkText("home"));
  }
}
