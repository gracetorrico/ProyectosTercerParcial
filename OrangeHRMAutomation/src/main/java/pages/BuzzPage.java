package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/li[1]/button[1]")
    WebElement deleteButton;

    @FindBy(className = "oxd-dropdown-menu")
    WebElement dropDownMenu;

    @FindBy(xpath = "//button[contains(., 'Yes, Delete')]")
    WebElement confirmDeleteButton;

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

    public void clickOnSubmitButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    public boolean isSuccessMessageDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
    public boolean isMsgDisplayed(String msg) throws InterruptedException {
        Thread.sleep(4000);
        for (WebElement msgElement : msgElements) {
            if (msgElement.getText().equals(msg)) {
                return true;
            }
        }
        return false;
    }

    public void clickOnDeleteButton(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
    }

    public void selectDelete(){
        wait.until(ExpectedConditions.visibilityOf(dropDownMenu));
        WebElement deletePostItem = dropDownMenu.findElement(By.xpath("//li[contains(@class, 'orangehrm-buzz-post-header-config-item') and .//p[contains(., 'Delete Post')]]"));
        deletePostItem.click();
    }

    public void clickOnConfirmDeleteButton(){
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteButton));
        confirmDeleteButton.click();
    }


}
