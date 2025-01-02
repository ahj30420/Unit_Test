package project.unitTesting;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FileContent {

    public final String fileName;
    public final List<String> lines;
}
