package indexing;

import indexing.FileIndexer;
import java.util.Map;

public class FileVisualizer {
    private FileIndexer fileIndexer;

    public FileVisualizer(FileIndexer fileIndexer) {
        this.fileIndexer = fileIndexer;
    }

    public void visualizeFiles() {
        for (Map.Entry<String, String> entry : fileIndexer.getFileIndex().entrySet()) {
            System.out.println("File: " + entry.getKey() + ", Path: " + entry.getValue());
        }
    }
}