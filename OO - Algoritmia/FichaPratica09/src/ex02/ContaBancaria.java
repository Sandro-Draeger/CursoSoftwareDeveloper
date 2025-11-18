package ex02;

public class ContaBancaria {
    private String iban;
    private String titular;
    private double saldo = 0;
    private int anoAbertura = 2025;
    private double margemEmprestimo = 0.5;
    private double valorDivida = 0;

    public ContaBancaria(String iban, String titular, double saldo, int anoAbertura, double margemEmprestimo, double valorDivida) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
        this.anoAbertura = anoAbertura;
        this.margemEmprestimo = margemEmprestimo;
        this.valorDivida = valorDivida;
    }

    public void pedirEmprestimo (double valor){
     if (valorDivida>0){
         System.out.println("Desconsiderado! Divida ativa");
     } else {
         double limiteValor = this.saldo * this.margemEmprestimo;
     }

    }

}
