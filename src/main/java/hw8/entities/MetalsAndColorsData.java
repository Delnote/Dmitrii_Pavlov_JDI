package hw8.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MetalsAndColorsData {
    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;
}
