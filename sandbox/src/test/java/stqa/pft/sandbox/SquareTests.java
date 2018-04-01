package stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Iwona Zajac on 01.04.2018.
 */
public class SquareTests {

  @Test
  public void testArea() {
    Squary s = new Squary(5);
    Assert.assertEquals(s.area(),25.0);
  }

}
