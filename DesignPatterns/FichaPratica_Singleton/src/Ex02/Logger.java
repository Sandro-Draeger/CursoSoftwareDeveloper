package Ex02;


import java.io.*;
import java.util.Scanner;

public class Logger {
    private static Logger instance;
    private File ficheiro;

    private Logger(File ficheiro) {
        this.ficheiro = ficheiro;
    }

    public static Logger getInstance(File ficheiro){
        if (instance == null) {
            instance = new Logger(ficheiro);
        }
        return instance;
    }

    public void log(String text) throws IOException {
     FileWriter writer = new FileWriter(ficheiro, true);

     writer.write(text);
     writer.close();
    }

    public void exibirDetalhes() throws IOException {
        Scanner scanner = new Scanner(ficheiro);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }


}

