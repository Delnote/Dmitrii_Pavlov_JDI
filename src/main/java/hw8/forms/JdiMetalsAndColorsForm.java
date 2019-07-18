package hw8.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
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

    @JDropdown(root = "#salad-dropdown",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret"
    )
    private Droplist vegetables;

    @UI("//ul[@class='panel-body-list results']")
    private UIElement logPanel;

    public void fill(MetalsAndColorsData macData) {

        vegetables.select(vegetables.getSelected());

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
//        // TODO Basically, this method should not be in PO.
//        // TODO take a look on streams, map, mapToInt, intStream
//        // Fixed
}