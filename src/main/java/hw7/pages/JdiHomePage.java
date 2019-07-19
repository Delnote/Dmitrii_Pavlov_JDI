package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import com.epam.jdi.light.ui.html.complex.Menu;
import hw7.entities.Users;
import hw7.forms.JdiLoginForm;
import org.hamcrest.Matchers;

public class JdiHomePage extends WebPage {

    private JdiLoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    @XPath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li[contains (string(), '%s')]")
    private Menu headerMenuItem;

    public void login(Users user) {
        profilePhoto.click();
        loginForm.login(user);
    }

    public void moveToMetalsAndColorsPage(String menuItem) {
        headerMenuItem.select(menuItem);
    }

    public void checkLoggedin(Users user) {
        userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
    }
}
