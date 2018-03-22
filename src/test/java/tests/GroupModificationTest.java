package tests;


import model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {


    @Test
    public void TestModificationGroup(){
        app.goTo().goToGroupsPage();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData().withFooter("footer").withHeader("H").withName("n"));
        }

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData().withFooter("footer").withHeader("H").withName("n"));
        app.getGroupHelper().confirmGroupModification();
        app.getGroupHelper().returnToGroupsPage();
    }

}
