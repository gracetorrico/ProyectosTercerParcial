package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class MyInfoPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "orangehrm-edit-employee-navigation")
    WebElement employeeInfoNavigation;

    @FindBy(css = "a[href='/web/index.php/pim/viewPersonalDetails/empNumber/7']")
    WebElement personalDetailsButton;

    @FindBy(css = "a[href=\"/web/index.php/pim/contactDetails/empNumber/7\"]")
    WebElement contactDetailsButton;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")
    //@FindBy(xpath = "//input[contains(@class, 'oxd-input--active')]")
    //@FindBy(xpath = "//input[@placeholder='Middle name']")
    WebElement middleNameTextBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input")
    WebElement driversLicenseNumber;

    //@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button")
    @FindBy(xpath = "//div/p/following-sibling::button")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")
    WebElement saveContactButton;

    //@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input")
    //@FindBy(xpath = "//input[contains(@class, 'oxd-input oxd-input--active') and @modelmodifiers='[object Object]']")
    //@FindBy(xpath = "//input[contains(@class, 'oxd-input--active') and @placeholder='Mobile Number']")
    //@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input")
    @FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement mobileNumberTextBox;

    //@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[2]/div/div[2]/input")
    @FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement otherEmailTextBox;

    @FindBy(xpath = "//*[@id=\"oxd-toaster_1\"]")
    WebElement successMessage;
    public MyInfoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isEmployeeInfoNavigationDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(employeeInfoNavigation));
        return employeeInfoNavigation.isDisplayed();
    }

    public void clickOnPersonalDetailsButton()
    {
        wait.until(ExpectedConditions.visibilityOf(personalDetailsButton));
        personalDetailsButton.click();
    }

    public void setMiddleNameTextBox(String userName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(middleNameTextBox));
        middleNameTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        middleNameTextBox.sendKeys(userName);
        System.out.println(middleNameTextBox.getText());
    }

    public String verifyMiddleNameTextBox() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(middleNameTextBox));
        return middleNameTextBox.getText();
    }
    public void setDriversLicenseNumber(String num)
    {
        wait.until(ExpectedConditions.visibilityOf(driversLicenseNumber));
        driversLicenseNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        driversLicenseNumber.sendKeys(num);
    }

    public void clickOnSaveButton()
    {
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    public void clickOnSaveContactButton()
    {
        wait.until(ExpectedConditions.visibilityOf(saveContactButton));
        saveContactButton.click();
    }
    public boolean isSuccessMessageDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
    public void clickOnContactDetailsButton()
    {
        wait.until(ExpectedConditions.visibilityOf(contactDetailsButton));
        contactDetailsButton.click();
    }

    public void setMobileNumber(String num)
    {
        wait.until(ExpectedConditions.visibilityOf(mobileNumberTextBox));
        mobileNumberTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        mobileNumberTextBox.sendKeys(num);
    }

    public void setOtherEmailTextBox(String num)
    {
        wait.until(ExpectedConditions.visibilityOf(otherEmailTextBox));
        otherEmailTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        otherEmailTextBox.sendKeys(num);
    }
}
