package HW7;

import com.epam.jdi.light.driver.get.DriverData;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static HW7.entities.MetalsAndColorsData.DATA_FORM;
import static HW7.entities.Users.PITER;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class JdiSiteTest {
    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
    }

    @Test
    public void differentElementsFormTest() {
        JdiSite.open();
        JdiSite.homePage.login(PITER);
        JdiSite.homePage.checkLoggedin(PITER);
        // TODO It will be better to make parametrised method
        // that can be used in order to open whatever page you want.
        JdiSite.homePage.moveToMetalsAndColorsPage();
        JdiSite.metalsAndColorsPage.fillMetalsAndColorsForm(DATA_FORM);
        JdiSite.metalsAndColorsPage.checkMetalsAndColorsFormResult(DATA_FORM);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
