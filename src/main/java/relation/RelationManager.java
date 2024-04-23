package management;

import java.util.HashMap;
import java.util.Map;

public class RelationManager {
    private Map<String, String> relations;

    public RelationManager() {
        this.relations = new HashMap<>();
    }

    public void addRelation(String key, String value) {
        this.relations.put(key, value);
    }

    public void removeRelation(String key) {
        this.relations.remove(key);
    }

    public String getRelation(String key) {
        return this.relations.get(key);
    }

    public Map<String, String> getRelations() {
        return this.relations;
    }
}