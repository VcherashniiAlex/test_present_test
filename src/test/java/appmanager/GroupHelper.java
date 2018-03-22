package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase{

    public void selectGroup() {
        click(By.name("selected[]"));

    }
    public void selectGroupByIndex(int index) {

        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void initGroupDeleted() {
        click(By.name("delete"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void confirmGroupModification() {
        click(By.name("update"));
    }

    public boolean isThereAGroup() {

        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm( group );
        submitGroupCreation();
        returnToGroupsPage();


    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            GroupData group = new GroupData().withName(name);
            groups.add(group);
        }
            return groups;
        }
    }
