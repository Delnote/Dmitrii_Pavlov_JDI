package HW7.forms;

import HW7.entities.MetalsAndColorsData;
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
        number.select(macData.getOdd());
        number.select(macData.getEven());
        colors.select(macData.getRed());
        element.select(macData.getFire(), macData.getWater());
        vegetables.select(macData.getVegTomato());
        vegetables.select(macData.getVegCucumber());
        metals.select(macData.getSelen());
    }

    public String addAndEvenSummResult(MetalsAndColorsData macData) {
        return  Integer.parseInt(macData.getOdd()) + Integer.parseInt(macData.getEven()) + "";
    }

}