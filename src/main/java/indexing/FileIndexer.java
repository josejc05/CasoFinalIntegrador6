package file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileIndexer {
    private Map<String, String> fileIndex;

    public FileIndexer() {
        this.fileIndex = new HashMap<>();
    }

    public void indexFiles(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                indexFiles(file);
            } else {
                fileIndex.put(file.getName(), file.getPath());
            }
        }
    }

    public Map<String, String> getFileIndex() {
        return fileIndex;
    }
}