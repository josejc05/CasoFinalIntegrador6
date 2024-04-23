package management;

import model.Pair;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<Pair> sortSalesByPrice(List<Pair> data) {
        return data.stream()
                .sorted(Comparator.comparing(Pair::getValue))
                .collect(Collectors.toList());
    }

    public List<Pair> sortSalesByName(List<Pair> data) {
        return data.stream()
                .sorted(Comparator.comparing(Pair::getKey))
                .collect(Collectors.toList());
    }

    public List<Pair> sortSalesByDate(List<Pair> data) {
        return data.stream()
                .sorted(Comparator.comparing(Pair::getDate))
                .collect(Collectors.toList());
    }

    public void analyzeData(List<Pair> data) {
        for (Pair datum : data) {
            System.out.println("Data: " + datum.getKey() + ", Value: " + datum.getValue() + ", Date: " + datum.getDate());
        }
    }
}