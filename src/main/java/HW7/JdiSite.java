package HW7;

import HW7.pages.JdiMetalsAndColorsPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import HW7.pages.JdiHomePage;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {
    @Url("index.html")
    @Title("Home Page")
    public static JdiHomePage homePage;
    public static JdiMetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        homePage.open();
    }
}
