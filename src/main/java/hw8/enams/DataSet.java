package hw8.enams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataSet {

    DATA_SET("src/test/resources/MetalsColorsDataSet.json");

    final String name;

}
