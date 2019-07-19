package hw77.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import hw77.entities.MetalsAndColorsData;
import hw77.forms.JdiMetalsAndColorsForm;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class JdiMetalsAndColorsPage extends WebPage {

    private JdiMetalsAndColorsForm metalsAndColorsForm;

    @XPath("//ul[@class = 'panel-body-list results']/li")
    private List<UIElement> resultSection;

    public void submitMetalsAndColorsForm(MetalsAndColorsData macData) {
        metalsAndColorsForm.fillMetalsAndColorsForm(macData);
        metalsAndColorsForm.submit.click();
    }

    public void checkMetalsAndColorsFormResult(MetalsAndColorsData macData) {
        Assert.assertEquals(actualLogList(), macData.expectedLogList());
    }

    private List<String> actualLogList() {
        return resultSection.stream().map(UIElement::getText).collect(Collectors.toList());
    }
}
