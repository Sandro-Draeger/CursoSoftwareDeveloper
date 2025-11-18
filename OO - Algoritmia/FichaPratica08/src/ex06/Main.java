package ex06;

public class Main {
    public static void main() {
        Livro livro1 = new Livro("A praça","Sandro Draeger","Suspense", 580, 1546545);
        Livro livro2 = new Livro("Justiça","Marcia Marica","Romance", 890, 794664545);

        livro1.exibirDetalhes();
        livro2.exibirDetalhes();
    }
}
