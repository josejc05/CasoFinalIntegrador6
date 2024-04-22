package model;

import java.util.ArrayList;
import java.util.List;

public class DataList {
    private List<String> dataList;

    public DataList() {
        this.dataList = new ArrayList<>();
    }

    public void addData(String data) {
        this.dataList.add(data);
    }

    public void removeData(String data) {
        this.dataList.remove(data);
    }

    public List<String> getDataList() {
        return this.dataList;
    }
}