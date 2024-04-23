package retrieval;

import model.Pair;
import java.util.List;

public class DataRetriever {
    public Pair retrieveData(List<Pair> data, int index) {
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        } else {
            return null;
        }
    }
}