package hw7.pages;

import hw7.entities.Users;
import hw7.forms.JdiLoginForm;
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

    @Css(".fa fa-sign-out")
    private Button logout;

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

    public void logout() {
        profilePhoto.click();
        logout.click();
    }
}
