package indexing;

import java.util.List;
import java.util.Map;

public class FileVisualizer {
    private FileIndexer fileIndexer;

    public FileVisualizer(FileIndexer fileIndexer) {
        this.fileIndexer = fileIndexer;
    }

    public void visualizeFiles() {
        Map<String, String> fileIndex = fileIndexer.getFileIndex();
        List<String> sortedFiles = fileIndex.keySet().stream().sorted().collect(Collectors.toList());
        for (String fileName : sortedFiles) {
            System.out.println("File: " + fileName + ", Path: " + fileIndex.get(fileName));
        }
    }
}