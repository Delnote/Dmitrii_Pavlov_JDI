package hw77.entities;

import lombok.*;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.join;
import static java.util.Arrays.asList;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MetalsAndColorsData {

    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<String> expectedLogList() {
        return asList(
                "Summary: " + summary.stream().mapToInt(Integer::parseInt).sum(),
                "Elements: " + join(", ", elements),
                "Color: " + color,
                "Metal: " + metals,
                "Vegetables: " + join(", ", vegetables)
        );
    }

    public static MetalsAndColorsData macDataHW7 = new MetalsAndColorsData(
            Arrays.asList("3", "8"),
            Arrays.asList("Water", "Fire"),
            "Red",
            "Selen",
            Arrays.asList("Cucumber", "Tomato"));
}
