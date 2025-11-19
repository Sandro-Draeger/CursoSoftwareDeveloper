package ex01;

import java.util.ArrayList;

public class MusicPlayer {
    private String criador;
    private ArrayList<String> programacaoMusical;

    public MusicPlayer(String criador, ArrayList programacaoMusical) {
        this.criador = criador;
        this.programacaoMusical = programacaoMusical;
    }

    public void adicionarMusica(Musica addMusica){
        for (int item = 0; item < programacaoMusical.size(); item++) {
            if (!programacaoMusical.equals(addMusica)) {
                programacaoMusical.add();
                System.out.println("Adicionado com sucesso!");
            } else {
                System.out.println("Esta música já esta na playlist.");
            }
        }
    }
    public void removerMusica(int indice){
        for (int item = 0; item < programacaoMusical.size(); item++) {
              if() {
                  programacaoMusical.remove(indice);
              } else {
                System.out.println("Removido com sucesso!");
            }
        }
    }
    }

