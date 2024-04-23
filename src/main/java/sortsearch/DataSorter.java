package sortsearch;

import model.Pair;
import java.util.Collections;
import java.util.List;

public class DataSorter {
    public void sortData(List<Pair> data) {
        Collections.sort(data, (Pair p1, Pair p2) -> {
            if (p1.getKey() instanceof String && p2.getKey() instanceof String) {
                return ((String) p1.getKey()).compareTo((String) p2.getKey());
            } else {
                return 0;
            }
        });
    }
}