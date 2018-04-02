package stqa.pft.addressbook;

import org.testng.annotations.Test;

/**
 * Created by Iwona Zajac on 02.04.2018.
 */
public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}
