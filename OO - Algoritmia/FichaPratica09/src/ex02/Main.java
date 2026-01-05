package ex02;

public class Main {
    static void main() {
        ContaBancaria conta01 = new ContaBancaria("CONTA01-23465465", "Alberto", 3000, 2024, 0.5, 0);
        ContaBancaria conta02 = new ContaBancaria("CONTA02-23465465", "Maria", 2000, 2012, 0.5, 0);
        ContaBancaria conta03 = new ContaBancaria("CONTA03-23465465", "Junior", 100, 2005, 1, 10);

        conta01.pedirEmprestimo(50);
        conta01.exibirDetalhes();

        conta03.pedirEmprestimo(100);
        conta03.exibirDetalhes();

        conta03.amortizarEmprestimo(10);
        conta03.exibirDetalhes();

        conta03.pedirEmprestimo(100);
        conta03.exibirDetalhes();

    }
}
