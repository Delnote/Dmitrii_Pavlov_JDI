package hw8.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import hw8.entities.MetalsAndColorsData;
import hw8.forms.JdiMetalsAndColorsForm;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Arrays.asList;

public class JdiMetalsAndColorsPage extends WebPage {

    private JdiMetalsAndColorsForm metalsAndColorsForm;

    @XPath("//ul[@class = 'panel-body-list results']/li")
    private List<UIElement> resultSection;

    public void fillMetalsAndColorsForm(MetalsAndColorsData macData) {
        metalsAndColorsForm.fill(macData);
    }

    public void submitMetalsAndColorsFormData() {
        metalsAndColorsForm.submit.click();
    }

    // TODO The certain sequence of log's rows doesn't matter in this case.
    // It will be easier to compare just two List<strings>
    // First list you can generate from MetalsAndColors instance
    // Second list can be generated from Log ui-element
    // Fixed
    public void checkMetalsAndColorsFormResult(MetalsAndColorsData macData) {
        Assert.assertEquals(actualLogList(), expectedLogList(macData));
    }
    
    private List<String> actualLogList() {
        return resultSection.stream().map(UIElement::getText).collect(Collectors.toList());
    }

    private List<String> expectedLogList(MetalsAndColorsData macData) {
        return asList(
                "Summary: " + macData.getSummary().stream().mapToInt(Integer::parseInt).sum(),
                "Elements: " + join(", ", macData.getElements()),
                "Color: " + macData.getColor(),
                "Metal: " + macData.getMetals(),
                "Vegetables: " + join(", ", macData.getVegetables())
        );
    }
}
