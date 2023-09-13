package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import utilities.DriverManager;
import utils.ScreenRecorderUtil;


public class Hooks {

    @AfterAll
    public static void afterScenario(){
        DriverManager.getDriver().driver.close();
    }

    @Before
    public void beforeTest() throws Exception {
        //ScreenRecorderUtil.startRecord("main");
    }

    @After
    public void afterTest() throws Exception {
        //ScreenRecorderUtil.stopRecord();
    }
}
