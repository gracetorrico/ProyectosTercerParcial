package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "oxd-topbar-header-title")
    WebElement pageTitle;

    @FindBy(className = "oxd-userdropdown-tab")
    WebElement userDropDown;
    @FindBy(css = "a[href='/web/index.php/pim/viewMyDetails']")
    WebElement myInfoButton;

    @FindBy(css="a[href=\"/web/index.php/buzz/viewBuzz\"]")
    WebElement buzzButton;

    @FindBy(css = "a[href='/web/index.php/auth/logout'][class='oxd-userdropdown-link']")
    WebElement logoutButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchInput;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean pageTitleIsDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.isDisplayed();
    }

    public void clickOnUserDropdown()
    {
        wait.until(ExpectedConditions.visibilityOf(userDropDown));
        userDropDown.click();
    }
    public void clickOnMyInfoButton(){
        wait.until(ExpectedConditions.visibilityOf(myInfoButton));
        myInfoButton.click();
    }
    public void clickOnBuzzButton(){
        wait.until(ExpectedConditions.visibilityOf(buzzButton));
        buzzButton.click();
    }
    public void clickOnLogoutButton(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }

    public void setSearchTextBox(String str)
    {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(str);
    }
    public boolean itemIsTheOnlyOne(String str)
    {
        WebElement ulElement = driver.findElement(By.cssSelector("ul.oxd-main-menu"));
        wait.until(ExpectedConditions.visibilityOf(ulElement));
        List<WebElement> liElements = ulElement.findElements(By.cssSelector("li.oxd-main-menu-item-wrapper"));
        //List<WebElement> liElements = ulElement.findElements(By.cssSelector("li"));
        int itemCount = 0;
        for (WebElement li : liElements) {
            if (li.getText().contains(str)) {
                itemCount++;
            }
        }

        return itemCount == 1;

    }
}
