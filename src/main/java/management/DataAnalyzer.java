package management;

import model.Pair;
import java.util.List;

public class DataAnalyzer {
    public void analyzeData(List<Pair> data) {
        for (Pair datum : data) {
            System.out.println("Data: " + datum.getKey() + ", Value: " + datum.getValue());
        }
    }
}