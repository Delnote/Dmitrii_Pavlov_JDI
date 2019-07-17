package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum MetalsAndColorsData {

    DATA_FORM(
            Arrays.asList("3", "8"),
            Arrays.asList("Fire", "Water"),
            "Red",
            "Selen",
            Arrays.asList("Tomato", "Cucumber"));

    private final List<String> summary;
    private final List<String> elements;
    private final String color;
    private final String metals;
    private final List<String> vegetables;
}
