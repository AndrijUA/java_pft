package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Iwona Zajac on 02.04.2018.
 */
public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
