package stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;
import stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

/**
 * Created by Iwona Zajac on 02.04.2018.
 */
public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.without(deletedGroup)));
  }

  @Test
  public void testGroupDeletionOld2() throws Exception {
    Set<GroupData> before = app.group().setAll();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().setAll();
    assertEquals(after.size(), before.size() - 1);

    before.remove(deletedGroup);
    assertEquals(before, after);
  }

  @Test
  public void testGroupDeletionOld0() throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    assertEquals(before, after);
  }

}
