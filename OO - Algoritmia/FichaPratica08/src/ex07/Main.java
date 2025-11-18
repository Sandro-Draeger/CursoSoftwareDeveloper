package ex07;

public class Main {
    public static void main() {
        Aluno aluno1 = new Aluno("Sandro", 29, "sandrosgafdsafda", "Software Developer", 15);
        Aluno aluno2 = new Aluno("Jorge", 29, "sandrosgafdsafda", "Software Developer", 7.5);

        System.out.println("*** Aprovação alunos ***");
        if (!aluno1.situacaoAprovacao()){
            System.out.println(aluno1.getNome() + " reprovado :(");
        } else {
            System.out.println(aluno1.getNome() + " aprovado!");
        }

        System.out.println("*** Aprovação alunos ***");
        if (!aluno2.situacaoAprovacao()){
            System.out.println(aluno2.getNome() + " reprovado :(");
        } else {
            System.out.println(aluno2.getNome() + " aprovado!");
        }
    }
}
