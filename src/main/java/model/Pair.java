package model;

public class Pair {
    private String key;
    private Double value;

    public Pair(String key, Double value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public Double getValue() {
        return this.value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}