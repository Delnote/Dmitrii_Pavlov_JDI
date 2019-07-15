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
import static hw7.entities.Users.PITER;
import static hw8.Enams.DataSet.DATA_SET;

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
        JdiSite.homePage.moveToMetalsAndColorsPage();
        JdiSite.metalsAndColorsPage.fillMetalsAndColorsForm(macData);
        JdiSite.metalsAndColorsPage.checkMetalsAndColorsFormResult(macData);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
