package ex01;

import java.util.ArrayList;

public class Main {
    static void main() {
        Musica m1 = new Musica("Chiriro", "Pop", "Billie Eilish", 210);
        Musica m2 = new Musica("Blue", "Pop", "Billie Eilish", 198);
        Musica m3 = new Musica("Wild Flower", "Pop", "Billie Eilish", 150);


        ArrayList<Musica> sandro = new ArrayList<Musica>();
        MusicPlayer nova = new MusicPlayer("PlayList Sandro", sandro);

        nova.adicionarMusica(m1);
        nova.adicionarMusica(m2);
        nova.adicionarMusica(m3);
        System.out.println("\n____________________________________________________\n");
        nova.imprimirRelatorio();
        System.out.println("\n____________________________________________________\n");
        nova.removerMusica(m2);
        System.out.println("\n____________________________________________________\n");
        nova.imprimirRelatorio();
        System.out.println("\n____________________________________________________\n");
        nova.trocarMusicas(0, 1);
        nova.imprimirRelatorio();
        System.out.println("\n____________________________________________________\n");
        nova.limparProgramacao();
        nova.imprimirRelatorio();
        System.out.println("\n____________________________________________________\n");
        nova.adicionarMusica(m1);
        nova.adicionarMusica(m2);
        nova.adicionarMusica(m3);
        System.out.println("\n____________________________________________________\n");
        nova.imprimirRelatorio();
        System.out.println("\n____________________________________________________\n");
        nova.trocarMusicas(0, 1);
        nova.imprimirRelatorio();

    }
}
