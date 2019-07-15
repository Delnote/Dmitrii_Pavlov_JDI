package HW7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MetalsAndColorsData {

    DATA_FORM("3", "8","Fire",
            "Water", "Red", "Selen",
            "Tomato", "Cucumber");

    // TODO Why don't you use collections here?
    private final String odd;
    private final String even;
    private final String fire;
    private final String Water;
    private final String Red;
    private final String Selen;
    private final String VegTomato;
    private final String VegCucumber;
}
