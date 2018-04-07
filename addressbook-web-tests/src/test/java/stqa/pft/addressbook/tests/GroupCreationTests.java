package stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData("test1", "test2", "test3");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

//    int max = 0;
//    for (GroupData g : after) {
//      if (g.getId() > max) {
//        max = g.getId();
//      }
//    }

//    group.setId(max);
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

  @Test
  public void testGroupCreationFieldDefault() throws Exception {
    app.goTo().groupPage();
    int before = app.group().getGroupCount();
    app.group().create(new GroupData("test1", null, null));
    int after = app.group().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }

}
