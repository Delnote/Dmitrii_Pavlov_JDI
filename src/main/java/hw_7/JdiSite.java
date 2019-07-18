package hw_7;

import hw_7.entities.HeaderMenu;
import hw_7.pages.JdiMetalsAndColorsPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw_7.pages.JdiHomePage;

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
}
