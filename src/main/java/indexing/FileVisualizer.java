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
        List<Map.Entry<String, String>> sortedEntries = fileIndex.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        StringBuilder filesInfo = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedEntries) {
            filesInfo.append("File: ").append(entry.getKey()).append(", Full Path: ").append(entry.getValue()).append("\n");
        }
        return filesInfo.toString();
    }
}