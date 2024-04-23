package file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FileSorter {
    public List<String> sortFiles(Map<String, String> fileIndex) {
        List<String> sortedFiles = new ArrayList<>(fileIndex.keySet());
        Collections.sort(sortedFiles);
        return sortedFiles;
    }
}