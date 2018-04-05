package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import stqa.pft.addressbook.tests.ContactModificationTests;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by Iwona Zajac on 02.04.2018.
 */
public class ApplicationManager {
  public WebDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private StringBuffer verificationErrors = new StringBuffer();
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser.equals(BrowserType.FIREFOX)) {
      System.setProperty("webdriver.gecko.driver", "C:\\SeleniumTools\\geckodriver.exe");
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTools\\chromedriver.exe\\");
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.EDGE)) {
      System.setProperty("webdriver.edge.driver", "C:\\SeleniumTools\\MicrosoftWebDriver.exe\\");
      wd = new EdgeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      System.setProperty("webdriver.ie.driver", "C:\\SeleniumTools\\IEDriverServer.exe\\");
      wd = new InternetExplorerDriver();
    }


    //driver = new EdgeDriver();

    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://127.0.0.1/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    sessionHelper.logout();
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
