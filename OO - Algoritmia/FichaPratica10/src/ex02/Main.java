package ex02;

import java.util.ArrayList;

public class Main {
    static void main() {

        Pessoa naruto = new Pessoa("Naruto", 18, 369852741, "naruto@aldeafolha.com");
        Pessoa sakura = new Pessoa("sakura", 18, 369852741, "sakura@aldeafolha.com");
        Pessoa sasuke = new Pessoa("Sasuke", 18, 369852741, "sasuke@aldeafolha.com");
        Pessoa konohamaru = new Pessoa("Konohamaru", 12, 369852741, "konohamaru@aldeafolha.com");
        Pessoa kakashi = new Pessoa("Kakashi", 30, 369852741, "kakashi@aldeafolha.com");


        Sorteio exameChunnin = new Sorteio("Exame Chunnin", "Se tornar Chunnin");

        exameChunnin.inscreverParticipantes(naruto);
        exameChunnin.inscreverParticipantes(sasuke);
        exameChunnin.inscreverParticipantes(sakura);
        System.out.println("\n__________________\n");
        exameChunnin.exibirDetalhes();

        System.out.println("\n__________________\n");
        exameChunnin.sortear().exibirDetalhes();
    }
}