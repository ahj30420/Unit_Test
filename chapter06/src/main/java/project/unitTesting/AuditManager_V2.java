package project.unitTesting;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class AuditManager_V2 {

    private final int maxEntriesPerFile;
    private final String directoryName;
    private final IFileSystem fileSystem;


    public void addRecord(String visitorName, LocalDateTime timeOfVisit) throws IOException {
        final List<String> filePaths = fileSystem.getFiles(directoryName);
        final List<Map.Entry<Integer, String>> sorted = sortByIndex(filePaths);

        final String newRecord = String.format("%s;%s",
                                               visitorName,
                                               timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
        );

        if (sorted.isEmpty()) {
            final String newFile = directoryName + "/audit_1.txt";
            fileSystem.writeAllText(newFile, newRecord);
            return;
        }

        final Map.Entry<Integer, String> latestFile = sorted.get(sorted.size() - 1);
        final int currentFileIndex = latestFile.getKey();
        final String currentFilePath = latestFile.getValue();
        final List<String> lines = fileSystem.readAllLines(currentFilePath);

        if (lines.size() < maxEntriesPerFile) {
            lines.add(newRecord);
            fileSystem.writeAllText(currentFilePath, String.join("\r\n", lines));
        }
        else {
            final int newIndex = currentFileIndex + 1;
            final String newName = String.format("audit_%d.txt", newIndex);
            fileSystem.writeAllText(directoryName + "/" + newName, newRecord);
        }
    }

    private List<Map.Entry<Integer, String>> sortByIndex(List<String> files) {
        final Map<Integer, String> map = new HashMap<>();
        IntStream.range(0, files.size())
                 .forEach(i -> map.put(getIndex(files.get(i)), files.get(i)));

        final List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByKey());
        return entries;
    }

    private int getIndex(String filePath) {
        final int underscoreIdx = filePath.lastIndexOf("_");
        final int dotIdx = filePath.lastIndexOf(".");
        return Integer.parseInt(filePath.substring(underscoreIdx + 1, dotIdx));
    }
}
