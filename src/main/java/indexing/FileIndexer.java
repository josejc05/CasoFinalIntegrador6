package indexing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileIndexer {
    private Map<String, String> fileIndex;

    public FileIndexer() {
        fileIndex = new HashMap<>();
    }

    public void indexFiles(String directoryPath) throws IOException {
        Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .forEach(file -> fileIndex.put(file.getFileName().toString(), file.toString()));
    }

    public String getFilePath(String fileName) {
        return fileIndex.get(fileName);
    }
}