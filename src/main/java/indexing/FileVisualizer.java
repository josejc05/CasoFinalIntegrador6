package indexing;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileVisualizer {
    private FileIndexer fileIndexer;

    public FileVisualizer(FileIndexer fileIndexer) {
        this.fileIndexer = fileIndexer;
    }

    public String visualizeFiles() {
        Map<String, String> fileIndex = fileIndexer.getFileIndex();
        List<String> sortedFiles = fileIndex.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder filesInfo = new StringBuilder();
        for (String fileName : sortedFiles) {
            filesInfo.append("File: ").append(fileName).append(", Full Path: ").append(fileIndex.get(fileName)).append("\n");
        }
        return filesInfo.toString();
    }
}