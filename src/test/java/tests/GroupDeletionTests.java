package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class GroupDeletionTests extends TestBase {
    @Test
    public void groupDeletionTest(){
        app.goTo().goToGroupsPage();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData().withFooter("footer").withHeader("H").withName("n"));
        }
        List<GroupData> before= app.getGroupHelper().getGroupList();
     //   int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroupByIndex(before.size()-1);

        app.getGroupHelper().initGroupDeleted();
        app.getGroupHelper().returnToGroupsPage();
        List<GroupData> after= app.getGroupHelper().getGroupList();
     //int after = app.getGroupHelper().getGroupCount();
        before.remove(before.size()-1);
for(int i=0; i<after.size(); i++){
    Assert.assertEquals(before.get(i), after.get(i));
}
        Assert.assertEquals(after.size(), before.size()-1);
    }

    public void selectGroup() {

        app.getGroupHelper().click(By.name("selected[]"));
    }

}
