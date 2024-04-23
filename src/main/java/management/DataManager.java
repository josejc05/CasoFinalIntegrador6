package management;

import model.Pair;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<Pair> data;

    public DataManager() {
        this.data = new ArrayList<>();
    }

    public void addData(Pair datum) {
        this.data.add(datum);
    }

    public void removeData(Pair datum) {
        this.data.remove(datum);
    }

    public List<Pair> getData() {
        return this.data;
    }
}