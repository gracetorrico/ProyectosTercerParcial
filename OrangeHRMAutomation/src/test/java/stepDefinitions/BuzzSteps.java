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
    public void clickOnPostButton() {
        buzzPage.clickOnSubmitButton();
    }

    @Then("A success post message should be displayed")
    public void verifySuccessPostMessage() {
        Assertions.assertTrue(buzzPage.isSuccessMessageDisplayed());
    }
    @And("The message should be displayed as {string}")
    public void verifyMessageDisplayed(String msg) {
        Assertions.assertTrue(buzzPage.isMsgDisplayed(msg));
    }
}
