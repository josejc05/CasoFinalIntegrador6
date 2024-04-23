package sortsearch;

import model.Pair;
import java.util.Collections;
import java.util.List;

public class DataSorter {
    public void sortData(List<Pair> data) {
        Collections.sort(data, (Pair p1, Pair p2) -> p1.getKey().compareTo(p2.getKey()));
    }
}