package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTest extends TestBase {



@DataProvider

public Iterator <Object []> validGroups() throws IOException{
List<Object[]> list=new ArrayList<>();
    BufferedReader reader= new BufferedReader(new FileReader
            (new File ("src/test/resources/groups.csv")));

    String line = reader.readLine();
    while (line !=null){
        String[] split =line.split(";");
        list.add(new Object[]{new GroupData().withName(split [0])
                .withFooter(split[1])
                .withHeader(split[2])});
line=reader.readLine();
    }

    return list.iterator();
}


    @Test (dataProvider = "validGroups")

    public void groupCreationTest(GroupData group) {
loger.info("Start test GroupCreationTest ");
        app.goTo().goToGroupsPage();
        app.getGroupHelper().isThereAGroup();
      List<GroupData> before= app.getGroupHelper().getGroupList();
        //   int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        List<GroupData> after= app.getGroupHelper().getGroupList();
     //   int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size()+1);
        loger.info("Stop test GroupCreationTest ");
    }

    @Test (enabled = false)
    public void GroupCreationTest1() {

        app.goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().withFooter("footer").withHeader("H").withName("n"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

    }

    @Test
    public void GroupCreationEmptyTest() {

        app.goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().withFooter("footer").withHeader("H").withName("n"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

    }

}
