package Ex04;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        FileManager fileManager = FileManager.getInstance("src/textFiles");

        fileManager.createFile(fileManager, "/file.txt");

    }
}
