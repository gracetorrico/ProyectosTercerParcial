package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BuzzPage
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "oxd-buzz-post-input")
    WebElement buzzTextBox;

    @FindBy(css = "button[type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"oxd-toaster_1\"]")
    WebElement successMessage;

    @FindBy(css = "p.oxd-text.oxd-text--p.orangehrm-buzz-post-body-text")
    List<WebElement> msgElements;

    public BuzzPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void setBuzzTextBox(String msg) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOf(buzzTextBox));
        buzzTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        buzzTextBox.sendKeys(msg);
        System.out.println(buzzTextBox.getText());
    }

    public void clickOnSubmitButton(){
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    public boolean isSuccessMessageDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
    public boolean isMsgDisplayed(String msg)
    {
        for (WebElement msgElement : msgElements) {
            if (msgElement.getText().equals(msg)) {
                return true;
            }
        }
        return false;
    }

}
