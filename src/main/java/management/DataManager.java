package management;

import model.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DataManager {
    private List<Pair> data;
    private TreeSet<String> sortedNames;

    public DataManager() {
        this.data = new ArrayList<>();
        this.sortedNames = new TreeSet<>();
    }

    public void addData(Pair datum) {
        this.data.add(datum);
        this.sortedNames.add(datum.getKey().toString());
    }

    public void removeData(Pair datum) {
        this.data.remove(datum);
        this.sortedNames.remove(datum.getKey().toString());
    }

    public List<Pair> getData() {
        return this.data;
    }

    public TreeSet<String> getSortedNames() {
        return this.sortedNames;
    }

    public boolean searchName(String name) {
        return this.sortedNames.contains(name);
    }
}