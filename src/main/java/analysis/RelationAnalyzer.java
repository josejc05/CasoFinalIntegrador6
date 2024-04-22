package analysis;

import java.util.Map;

public class RelationAnalyzer {
    public void analyzeRelations(Map<String, String> relations) {
        for (Map.Entry<String, String> entry : relations.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}