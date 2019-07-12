package HW7.pages;

import HW7.entities.Users;
import HW7.forms.JdiLoginForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import org.hamcrest.Matchers;

public class JdiHomePage extends WebPage {

    private JdiLoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    @XPath("//a[text() ='Metals & Colors']")
    private Button metalsAndColorsItem;

    public void login(Users user) {
        profilePhoto.click();
        loginForm.login(user);
    }

    public void moveToMetalsAndColorsPage() {
        metalsAndColorsItem.click();
    }

    public void checkLoggedin(Users user) {
        userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
    }
}
