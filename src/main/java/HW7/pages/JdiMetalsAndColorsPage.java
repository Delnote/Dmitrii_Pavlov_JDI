package HW7.pages;

import HW7.entities.MetalsAndColorsData;
import HW7.forms.JdiMetalsAndColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Text;
import org.hamcrest.Matchers;

import java.util.Arrays;

import static HW7.entities.MetalsAndColorsData.DATA_FORM;

public class JdiMetalsAndColorsPage extends WebPage {

    private JdiMetalsAndColorsForm metalsAndColorsForm;

    @XPath("//ul[@class = 'panel-body-list results']")
    private Text result;

    public void fillMetalsAndColorsForm(MetalsAndColorsData macData) {

        metalsAndColorsForm.fill(macData);
        metalsAndColorsForm.submit.click();
    }

    public void checkMetalsAndColorsFormResult(MetalsAndColorsData macData) {
        result.shouldBe().text(Matchers.containsString("Summary: " + metalsAndColorsForm.addAndEvenSummResult(DATA_FORM)));
        result.shouldBe().text(Matchers.containsString("Color: " + macData.getRed()));
        result.shouldBe().text(Matchers.containsString("Metal: " + macData.getSelen()));
        result.shouldBe().text(Matchers.containsString("Vegetables: " + macData.getVegCucumber() + ", " + macData.getVegTomato()));
        result.shouldBe().text(Matchers.containsString("Elements: " + macData.getWater() + ", " + macData.getFire()));
    }
}
