package retrieval;

import java.util.List;

public class DataRetriever {
    public String retrieveData(List<String> data, int index) {
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        } else {
            return null;
        }
    }
}