package management;

import java.util.List;

public class DataAnalyzer {
    public void analyzeData(List<String> data) {
        for (String datum : data) {
            System.out.println("Data: " + datum);
        }
    }
}