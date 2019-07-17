package hw8.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.MultiDropdown;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw8.entities.MetalsAndColorsData;

public class JdiMetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @Css(".radio")
    private RadioButtons number;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist colors;

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist metals;

    @XPath("//label[string()='%s']")
    private UIElement element;

    @Css("#submit-button")
    public Button submit;

    @Css("#vegetables")
    private MultiDropdown vegetables;

    @UI("//ul[@class='panel-body-list results']")
    private UIElement logPanel;

    public void fill(MetalsAndColorsData macData) {

        colors.select(macData.getColor());
        metals.select(macData.getMetals());

        for (String item : macData.getSummary()) {
            number.select(item);
        }

        for (String item : macData.getElements()) {
            element.select(item);
        }

        for (String item : macData.getVegetables()) {
            vegetables.select(item);
        }
    }

    public String oddAndEvenSumResult(MetalsAndColorsData macData) {
        // TODO Basically, this method should not be in PO.
        // TODO take a look on streams, map, mapToInt, intStream
        int res = 0;
        for (String num : macData.getSummary()) {
            res += Integer.parseInt(num);
        }
        return res + "";
    }

}