package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Text;
import hw7.entities.MetalsAndColorsData;
import hw7.forms.JdiMetalsAndColorsForm;
import org.hamcrest.Matchers;

import java.util.Arrays;

public class JdiMetalsAndColorsPage extends WebPage {

    private JdiMetalsAndColorsForm metalsAndColorsForm;

    @XPath("//ul[@class = 'panel-body-list results']")
    private Text result;

    public void fillMetalsAndColorsForm(MetalsAndColorsData macData) {

        // TODO You submit(send the data to the server) this form rather than just fill it.
        // Fixed
        metalsAndColorsForm.fill(macData);
    }

    public void submitMetalsAndColorsFormData() {
        metalsAndColorsForm.submit.click();
    }

    public void checkMetalsAndColorsFormResult(MetalsAndColorsData macData) {
        result.shouldBe().text(Matchers.stringContainsInOrder(Arrays
                .asList("Summary", metalsAndColorsForm
                        .addAndEvenSummResult(macData))));

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
