package stqa.pft.addressbook.tests;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import stqa.pft.addressbook.model.GroupData;
import stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsWithCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")))) {
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validGroupsWithXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validGroupsWithJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
      }.getType());
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validGroupsWithJson")
  public void testGroupCreationProvider(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.db().groups();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.db().groups();

    before.add(group);
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    verifyGroupListInUI();
  }

//  @Test(dataProvider = "validGroupsWithJson")
//  public void testGroupCreationProvider(GroupData group) {
//    app.goTo().groupPage();
//    Groups before = app.group().all();
//    app.group().create(group);
//    assertThat(app.group().count(), equalTo(before.size() + 1));
//    Groups after = app.group().all();
//
//    before.add(group);
//    assertThat(after, equalTo(
//            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
//  }

//  @Test
//  public void testGroupCreation() throws Exception {
//    app.goTo().groupPage();
//    Groups before = app.group().all();
//    GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
//    app.group().create(group);
//    assertThat(app.group().count(), equalTo(before.size() + 1));
//    Groups after = app.group().all();
//
//    before.add(group);
//    assertThat(after, equalTo(
//            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
//  }
//
//  @Test
//  public void testBadGroupCreation() throws Exception {
//    app.goTo().groupPage();
//    Groups before = app.group().all();
//    GroupData group = new GroupData().withName("test1'");
//    app.group().create(group);
//    assertThat(app.group().count(), equalTo(before.size()));
//    Groups after = app.group().all();
//
////    before.add(group);
//    assertThat(after, equalTo(before));
//  }
//
//  @Test
//  public void testGroupCreationFieldDefault() throws Exception {
//    app.goTo().groupPage();
//    int before = app.group().count();
//    app.group().create(new GroupData().withName("test1"));
//    int after = app.group().count();
//    Assert.assertEquals(after, before + 1);
//  }
//
//
//  @Test
//  public void testGroupCreationOld0() throws Exception {
//    app.goTo().groupPage();
//    List<GroupData> before = app.group().list();
//    GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
//    app.group().create(group);
//    List<GroupData> after = app.group().list();
//    Assert.assertEquals(after.size(), before.size() + 1);
//
////    int max = 0;
////    for (GroupData g : after) {
////      if (g.getId() > max) {
////        max = g.getId();
////      }
////    }
//
////    group.setId(max);
//    group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//    before.add(group);
//    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
//  }
//
//  @Test
//  public void testGroupCreationOld2() throws Exception {
//    app.goTo().groupPage();
//    Set<GroupData> before = app.group().setAll();
//    GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
//    app.group().create(group);
//    Set<GroupData> after = app.group().setAll();
////    Assert.assertEquals(after.size(), before.size() + 1);
//    assertThat(after.size(), equalTo(before.size() + 1));
//
//    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
//    before.add(group);
////    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
//    assertThat(after, equalTo(before));
//  }
}
