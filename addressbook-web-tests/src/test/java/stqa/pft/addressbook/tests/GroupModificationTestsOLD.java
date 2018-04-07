package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Iwona Zajac on 02.04.2018.
 */
public class GroupModificationTestsOLD extends TestBase {

  @Test
  public void testGroupModification() {
    app.goTo().groupPage();
    if (!app.group().isThereAGroup()) {
      app.group().create(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.group().list();
    app.group().select(before.size() - 1);
    app.group().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test1", "test4", "test5");
    app.group().fillGroupForm(group);
    app.group().submitGroupModification();
    app.group().returnToGroupPage();
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    //sortowanie list
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
    //porównanie dwóch posortowanycj list
//    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
