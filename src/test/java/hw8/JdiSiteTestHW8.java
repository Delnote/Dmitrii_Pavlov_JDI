package hw8;

import BaseTest.BaseTest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import hw7.JdiSite;
import hw7.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static hw7.entities.DataSet.DATA_SET;
import static hw7.entities.HeaderMenu.METALS_AND_COLORS;

public class JdiSiteTestHW8 extends BaseTest {

    @DataProvider(name = "metalsAndColorsTestDataSet")
    public Object[] getData() throws FileNotFoundException {
            JsonElement jsonData = new JsonParser()
                    .parse(new FileReader(DATA_SET.getName()));
            Map<String, MetalsAndColorsData> testDataSet = new Gson()
                    .fromJson(jsonData, new TypeToken<Map<String, MetalsAndColorsData>>() {}
                    .getType());

            return testDataSet.values().toArray();
    }

    @Test (dataProvider = "metalsAndColorsTestDataSet")
    public void differentElementsFormTest(MetalsAndColorsData macData) {
        // TODO I don't get it. Read my previous comment again.
        // I expected that you create method like
        // openPageByHeaderMenu(HEADER_MENU.HOME)
        // openPageByHeaderMenu(HEADER_MENU.METALS_AND_COLORS)
        // ...

        JdiSite.openPageByHeaderMenu(METALS_AND_COLORS);
        JdiSite.metalsAndColorsPage.submitMetalsAndColorsForm(macData);
        JdiSite.metalsAndColorsPage.checkMetalsAndColorsFormResult(macData);
    }
}
