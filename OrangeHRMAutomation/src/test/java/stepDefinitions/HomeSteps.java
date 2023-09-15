package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import utilities.DriverManager;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @Then("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(homePage.pageTitleIsDisplayed());
    }

    @And("I logout")
    public void logout()
    {
        homePage.clickOnUserDropdown();
        homePage.clickOnLogoutButton();
    }
    @Given("I click on My Info button")
    public void clickOnMyInfoButton() {
        homePage.clickOnMyInfoButton();
    }

    @Given("I click on Buzz NewsFeed")
    public void clickOnBuzzNewsFeed() {
        homePage.clickOnBuzzButton();
    }

    @Given("I Search {string} on search menu")
    public void iSearchOnSearchMenu(String str) {
        homePage.setSearchTextBox(str);
    }

    @Then("The option {string} should be the only one")
    public void theOptionShouldBeTheOnlyOne(String str) {
        homePage.itemIsTheOnlyOne(str);
    }
}
