package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.LoginPage;
import utilities.DriverManager;

public class CommonSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
    @Given("I am in Orange HRM web page")
    public void goToOrangePage() throws InterruptedException {
        DriverManager.getDriver().driver.get("https://opensource-demo.orangehrmlive.com/");
        DriverManager.getDriver().driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Given("I am in Orange HRM Home web page")
    public void goToSauceLoginPage() throws InterruptedException {
        DriverManager.getDriver().driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        DriverManager.getDriver().driver.manage().window().maximize();
        loginPage.setUserNameTextBox("Admin");
        loginPage.setPasswordTextBox("admin123");
        Thread.sleep(2000);
        loginPage.clickOnLoginButton();
    }
}
