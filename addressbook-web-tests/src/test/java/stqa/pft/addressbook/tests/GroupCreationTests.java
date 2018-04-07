package stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import stqa.pft.addressbook.model.GroupData;
import stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(),equalTo(before.size()+1));

    before.add(group);
    assertThat(after,equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testGroupCreationFieldDefault() throws Exception {
    app.goTo().groupPage();
    int before = app.group().getGroupCount();
    app.group().create(new GroupData().withName("test1"));
    int after = app.group().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }


  @Test
  public void testGroupCreationOld0() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
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
    group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

  @Test
  public void testGroupCreationOld2() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().setAll();
    GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
    app.group().create(group);
    Set<GroupData> after = app.group().setAll();
//    Assert.assertEquals(after.size(), before.size() + 1);
    assertThat(after.size(),equalTo(before.size()+1));

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
//    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    assertThat(after,equalTo(before));
  }
}
