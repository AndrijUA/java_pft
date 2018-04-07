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
      app.group().create(new GroupData().withName("test1"));
    }
    List<GroupData> before = app.group().list();
    app.group().selectGroup(before.size() - 1);
    app.group().initGroupModification();
    GroupData group = new GroupData()
            .withId(before.get(before.size() - 1).getId())
            .withName("test1").withHeader("test4").withFooter("test5");
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
