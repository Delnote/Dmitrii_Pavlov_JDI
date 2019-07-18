package hw8;

import com.epam.jdi.light.driver.get.DriverData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import hw8.entities.MetalsAndColorsData;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static hw7.entities.HeaderMenu.METALS_AND_COLORS;
import static hw7.entities.Users.PITER;
import static hw8.enams.DataSet.DATA_SET;

public class JdiSiteTest {

    @DataProvider(name = "metalsAndColorsTestDataSet")
    public Object[] getData() throws FileNotFoundException {
            JsonElement jsonData = new JsonParser()
                    .parse(new FileReader(DATA_SET.getName()));
            Map<String, MetalsAndColorsData> testDataSet = new Gson()
                    .fromJson(jsonData, new TypeToken<Map<String, MetalsAndColorsData>>() {}
                    .getType());

            return testDataSet.values().toArray();
    }


    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);

        JdiSite.open();
        JdiSite.homePage.login(PITER);
        JdiSite.homePage.checkLoggedin(PITER);
    }

    @Test (dataProvider = "metalsAndColorsTestDataSet")
    public void differentElementsFormTest(MetalsAndColorsData macData) {
        // TODO I don't get it. Read my previous comment again.
        // I expected that you create method like
        // openPageByHeaderMenu(HEADER_MENU.HOME)
        // openPageByHeaderMenu(HEADER_MENU.METALS_AND_COLORS)
        // ...

        JdiSite.openPageByHeaderMenu(METALS_AND_COLORS);
        JdiSite.fillMetalsAndColorsForm(macData);
        JdiSite.submitForm();
        JdiSite.checkMetalsAndColorsFormReasultData(macData);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
