package FichasPraticas02;

import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double saldo, operacao, saldoAtual;

        System.out.println("insira seu saldo atual: ");
        saldo = input.nextDouble();

        System.out.println("qual valor deseja movimentar: ");
        operacao = input.nextDouble();

        saldoAtual = saldo + operacao;

        if (saldoAtual >= 0) {
            System.out.println("Saldo Atual: " + saldoAtual);
        } else  {
            System.out.println("Operação Inválida. Saldo Insuficiente");
        }
        }


}
