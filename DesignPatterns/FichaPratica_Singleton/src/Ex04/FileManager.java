package Ex04;

import Ex03.UserSessionManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static FileManager instance;

    private String nomeFicheiro;
    private String rootDirectory;

    public FileManager(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public static FileManager getInstance(String rootDirectory){
        if (instance == null) {
            instance = new FileManager(rootDirectory);
        }
        return instance;
    }


     public static File createFile(FileManager fileManager, String nomeFicheiro) throws IOException {
        String directory = fileManager.rootDirectory;
        File file = new File(directory, nomeFicheiro);
         return file;
     }

     public static void deleteFile(File file) throws IOException {
        file.delete();
     }
}
