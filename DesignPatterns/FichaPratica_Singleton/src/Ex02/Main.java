package Ex02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getInstance(new File("aplicattion.txt"));

        logger.log("\nLog 1 - Variável x definida para 20");
        logger.log("\nLog 2: Objeto “porsche” da Classe Car criado com sucesso");
        logger.exibirDetalhes();

        Logger mylogger = Logger.getInstance(new File("programa.txt"));

        mylogger.log("\nLog 3: Objeto “mercedes” da Classe Car criado com sucesso");
        mylogger.log("\nLog 4: Método corrida invocado entre porsche e mercedes");
        mylogger.log("\nLog 5: Vencedor da corrida é porsche");
        mylogger.exibirDetalhes();
    }
}