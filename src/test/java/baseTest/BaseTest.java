package baseTest;

import com.epam.jdi.light.driver.get.DriverData;
import hw7.JdiSite;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static hw7.entities.Users.PITER;

public class BaseTest {

    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
        
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }

}
