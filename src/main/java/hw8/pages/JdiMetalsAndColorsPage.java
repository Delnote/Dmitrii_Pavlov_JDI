package hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Text;
import hw8.entities.MetalsAndColorsData;
import hw8.forms.JdiMetalsAndColorsForm;
import org.hamcrest.Matchers;

import java.util.Arrays;

public class JdiMetalsAndColorsPage extends WebPage {

    private JdiMetalsAndColorsForm metalsAndColorsForm;

    @XPath("//ul[@class = 'panel-body-list results']")
    private Text result;

    public void fillMetalsAndColorsForm(MetalsAndColorsData macData) {

        metalsAndColorsForm.fill(macData);
        metalsAndColorsForm.submit.click();
    }

    public void checkMetalsAndColorsFormResult(MetalsAndColorsData macData) {

        result.shouldBe().text(Matchers.stringContainsInOrder(Arrays
                .asList("Summary", metalsAndColorsForm
                .oddAndEvenSummResult(macData))));

        result.shouldBe().text(Matchers.stringContainsInOrder(Arrays
                .asList("Color", macData.getColor())));

        result.shouldBe().text(Matchers.stringContainsInOrder(Arrays
                .asList("Metal", macData.getMetals())));

        for (String item : macData.getElements()) {
            result.shouldBe().text(Matchers.stringContainsInOrder(Arrays.asList("Elements", item)));
        }

        for (String item : macData.getVegetables()) {
            result.shouldBe().text(Matchers.stringContainsInOrder(Arrays.asList("Vegetables", item)));
        }
    }
}
