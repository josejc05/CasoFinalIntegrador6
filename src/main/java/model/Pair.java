package model;

import java.util.List;

public class Pair {
    private String key;
    private List<Pair> value;

    public Pair(String key, List<Pair> value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public List<Pair> getValue() {
        return this.value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(List<Pair> value) {
        this.value = value;
    }
}