package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "input[name='username']")
    WebElement userNameTextBox;

    @FindBy(css = "input[name='password']")
    WebElement passwordTextBox;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(css = "//div[contains(@class, 'oxd-alert--error')]")
    WebElement loginErrorMessage;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setUserNameTextBox(String userName)
    {
        wait.until(ExpectedConditions.visibilityOf(userNameTextBox));
        userNameTextBox.sendKeys(userName);
    }

    public void setPasswordTextBox(String password)
    {
        wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton()
    {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public boolean isErrorTextDisplayed(String error){
        WebElement loginErrorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'oxd-alert--error')]")));
        String actualErrorMessage = loginErrorMessage.getText();
        return error.equalsIgnoreCase(actualErrorMessage);
    }
    public boolean isLoginButtonDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton.isDisplayed();
    }
}
