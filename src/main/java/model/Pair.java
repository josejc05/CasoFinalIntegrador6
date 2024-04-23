package model;

import java.util.List;

public class Pair {
    private Object key;
    private List<Pair> value;

    public Pair(Object key, List<Pair> value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return this.key;
    }

    public List<Pair> getValue() {
        return this.value;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public void setValue(List<Pair> value) {
        this.value = value;
    }
}