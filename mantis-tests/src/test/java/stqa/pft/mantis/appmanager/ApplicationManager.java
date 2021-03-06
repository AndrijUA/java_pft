package stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Iwona Zajac on 02.04.2018.
 */
public class ApplicationManager {
  private final Properties properties;
  public WebDriver wd;

  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

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
  }

  public void stop() {
    wd.quit();
  }
}
