import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import utilities.DriverManager;

public class BaseTest {

    @BeforeEach
    public void setup(){
        DriverManager.getDriver().driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        DriverManager.getDriver().driver.manage().window().maximize();
    }

    @AfterAll
    public static void cleanUp(){
        DriverManager.getDriver().driver.close();
    }
}
