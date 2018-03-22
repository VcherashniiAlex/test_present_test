package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class TestBase {

        protected static ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    Logger loger= LoggerFactory.getLogger(TestBase.class );
        @BeforeSuite
        public void setUp() throws Exception {
            app.start();
        }
@BeforeMethod

public void logTestStart(Method m, Object [] p){

      loger.info("Start test"+ m.getName()+" with parameter "+ p);
}
@AfterMethod (alwaysRun =true)
public void logTestStop(Method m, Object [] p ){
    loger.info("Stop test"+ m.getName()+" with parameter "+ p);
}

 @AfterSuite
        public void tearDown() {
            app.stop();
        }}






