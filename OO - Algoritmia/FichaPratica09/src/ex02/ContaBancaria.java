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

    public void pedirEmprestimo(double valorEmprestimo) {
        if (this.valorDivida > 0) {
            System.out.println("Erro - Divida ativa");
        } else {
            double limiteValor = this.saldo * this.margemEmprestimo;
            valorEmprestimo = limiteValor - valorEmprestimo;
            this.saldo = this.saldo + valorEmprestimo;
            this.valorDivida = this.valorDivida + valorEmprestimo;
            System.out.println("Emprestimo realizado com sucesso");
        }
    }

    public void amortizarEmprestimo(double valorQuitar) {
        if (this.valorDivida >= valorQuitar) {
            if (this.saldo >= valorQuitar) {
                this.valorDivida = this.valorDivida - valorQuitar;
                this.saldo = this.saldo - valorQuitar;
                System.out.println("efetivado com sucesso");
            } else {
                System.out.println("Erro, saldo insuficiente!");
            }
        } else {
            System.out.println("Erro, valor em excesso!");
        }
    }
    public void exibirDetalhes() {
        System.out.println(this.titular + " | "+this.iban + " = saldo: "+this.saldo);
    }
}
