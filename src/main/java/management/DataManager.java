package management;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<String> data;

    public DataManager() {
        this.data = new ArrayList<>();
    }

    public void addData(String datum) {
        this.data.add(datum);
    }

    public void removeData(String datum) {
        this.data.remove(datum);
    }

    public List<String> getData() {
        return this.data;
    }
}