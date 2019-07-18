package hw8;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.entities.HeaderMenu;
import hw7.pages.JdiHomePage;
import hw8.entities.MetalsAndColorsData;
import hw8.pages.JdiMetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {
    @Url("index.html")
    @Title("Home Page")
    public static JdiHomePage homePage;
    public static JdiMetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        homePage.open();
    }

    public static void openPageByHeaderMenu(HeaderMenu menuItem) {
        homePage.moveToMetalsAndColorsPage(menuItem.getHeaderMenuItem());
    }

    public static void fillMetalsAndColorsForm(MetalsAndColorsData macData) {
        metalsAndColorsPage.fillMetalsAndColorsForm(macData);
    }

    public static void submitForm() {
        metalsAndColorsPage.submitMetalsAndColorsFormData();
    }

    public static void checkMetalsAndColorsFormReasultData (MetalsAndColorsData macData) {
        metalsAndColorsPage.checkMetalsAndColorsFormResult(macData);
    }

}
