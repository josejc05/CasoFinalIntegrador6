package relation;

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

    public Map<String, String> getRelations() {
        return this.relations;
    }
}