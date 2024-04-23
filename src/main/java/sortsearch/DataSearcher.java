package sortsearch;

import model.Pair;
import java.util.List;

public class DataSearcher {
    public int searchData(List<Pair> data, String target) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getKey().equals(target)) {
                return i;
            }
        }
        return -1;
    }
}