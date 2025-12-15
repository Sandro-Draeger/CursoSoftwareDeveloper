package ex10;

public class ContaBancaria {
    private String iban;
    private String titular;
    private double saldo = 0;


    public ContaBancaria(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
    }


    public void depositar(double deposito){
        this.saldo = this.saldo + deposito;
        System.out.println(deposito + " adicionado na conta: " + this.iban);
    }

    public void levantar(double levantamento){
        if (levantamento<=this.saldo){
        this.saldo = this.saldo - levantamento;
        System.out.println(levantamento + " retirado da conta: " + this.iban);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void transferencia(ContaBancaria contaDestino, double valorTransferencia) {
        if (valorTransferencia <= this.saldo) {
            this.saldo -= valorTransferencia;
            contaDestino.saldo += valorTransferencia;
            System.out.println("Transferência de "+valorTransferencia+" efectuada com sucesso para conta: "+this.iban);
        } else {
            System.out.println("Saldo insufíciente");
        }
    }
}