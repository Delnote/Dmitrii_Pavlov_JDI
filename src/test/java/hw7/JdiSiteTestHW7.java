package hw7;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static hw7.entities.HeaderMenu.METALS_AND_COLORS;
import static hw7.entities.MetalsAndColorsData.macDataHW7;

public class JdiSiteTestHW7 extends BaseTest {

    @Test
    public void differentElementsFormTest() {
        // TODO It will be better to make parametrised method
        // that can be used in order to open whatever page you want.
        // Fixed
        JdiSite.openPageByHeaderMenu(METALS_AND_COLORS);
        JdiSite.metalsAndColorsPage.submitMetalsAndColorsForm(macDataHW7);
        JdiSite.metalsAndColorsPage.checkMetalsAndColorsFormResult(macDataHW7);
    }
}
