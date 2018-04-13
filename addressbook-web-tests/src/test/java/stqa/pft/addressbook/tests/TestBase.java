package stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import stqa.pft.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Iwona Zajac on 02.04.2018.
 */
public class TestBase {
  Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method method, Object[] parameters) {
    logger.info("Start test " + method.getName() + " with parameters " + Arrays.asList(parameters));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method method) {
    logger.info("Stop test " + method.getName());
  }

}
