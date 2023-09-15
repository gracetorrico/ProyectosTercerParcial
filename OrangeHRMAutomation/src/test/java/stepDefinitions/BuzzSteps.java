package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.BuzzPage;
import utilities.DriverManager;

public class BuzzSteps
{
    BuzzPage buzzPage = new BuzzPage(DriverManager.getDriver().driver);

    @Given("I add the following text {string} to the buzz newsfeed")
    public void addMessage(String msg) throws InterruptedException {
        buzzPage.setBuzzTextBox(msg);
    }

    @And("I click on Post Button")
    public void clickOnPostButton() throws InterruptedException {
        buzzPage.clickOnSubmitButton();
    }

    @Then("A success message should be shown")
    public void verifySuccessPostMessage() {
        Assertions.assertTrue(buzzPage.isSuccessMessageDisplayed());
    }
    @And("The message should be displayed as {string}")
    public void verifyMessageDisplayed(String msg) throws InterruptedException {
        Assertions.assertTrue(buzzPage.isMsgDisplayed(msg));
    }

    @Then("I click on delete button")
    public void clickOnDeleteButton() {
        buzzPage.clickOnDeleteButton();
        buzzPage.selectDelete();
    }

    @And("The message {string} should not be displayed")
    public void theMessageShouldNotBeDisplayed(String str) throws InterruptedException {
        Assertions.assertFalse(buzzPage.isMsgDisplayed(str));
    }

    @And("I confirm deleting the message")
    public void confirmDeletingTheMessage() throws InterruptedException {
        buzzPage.clickOnConfirmDeleteButton();
    }
}
