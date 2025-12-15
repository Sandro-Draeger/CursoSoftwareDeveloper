package ex10;

public class Main {
    static void main() {
        ContaBancaria conta1 = new ContaBancaria("BN123456789", "Sandro");
        ContaBancaria conta2 = new ContaBancaria("BN789456123", "Aricia");

        conta1.depositar(1000);

        conta1.transferencia(conta2,200);
        conta2.transferencia(conta1, 200);

        conta1.levantar(50);
    }
}
