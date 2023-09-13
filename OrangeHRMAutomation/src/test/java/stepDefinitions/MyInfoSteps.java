package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.MyInfoPage;
import utilities.DriverManager;

public class MyInfoSteps
{
    MyInfoPage myInfoPage = new MyInfoPage(DriverManager.getDriver().driver);

    @And("My Info page is displayed")
    public void infoPageIsDisplayed()
    {
        Assertions.assertTrue(myInfoPage.isEmployeeInfoNavigationDisplayed());
    }

    @Then("I change Middle Name to {string}")
    public void iChangeMiddleNameTo(String mname) throws InterruptedException {
        myInfoPage.setMiddleNameTextBox(mname);
    }

    @And("I change Drivers License number to {string}")
    public void iChangeDriversLicenseNumberTo(String num) {
        myInfoPage.setDriversLicenseNumber(num);
    }

    @And("I click on Save button")
    public void iClickOnSaveButton() throws InterruptedException {
        Thread.sleep(7000);
        myInfoPage.clickOnSaveButton();
    }

    @When("I click on Personal Details button")
    public void iClickOnPersonalDetailsButton() {
        myInfoPage.clickOnPersonalDetailsButton();
    }

    @Then("A success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() {
        Assertions.assertTrue(myInfoPage.isSuccessMessageDisplayed());
    }

    @When("I click on Contact Details button")
    public void iClickOnContactDetailsButton() {
        myInfoPage.clickOnContactDetailsButton();
    }

    @Then("I change mobile number to {string}")
    public void iChangeMobileNumberTo(String num) {
        myInfoPage.setMobileNumber(num);
    }

    @And("I change second email to {string}")
    public void iChangeSecondEmailTo(String str) throws InterruptedException {
        myInfoPage.setOtherEmailTextBox(str);
    }

    @And("I click on Save Contact button")
    public void iClickOnSaveContactButton() {
        myInfoPage.clickOnSaveContactButton();
    }
}
