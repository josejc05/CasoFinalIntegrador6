package model;

import java.util.Date;

public class Pair {
    private String key;
    private Double value;
    private Date date;

    public Pair(String key, Double value, Date date) {
        this.key = key;
        this.value = value;
        this.date = date;
    }

    public String getKey() {
        return this.key;
    }

    public Double getValue() {
        return this.value;
    }

    public Date getDate() {
        return this.date;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}