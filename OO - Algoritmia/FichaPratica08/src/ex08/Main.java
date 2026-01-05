package ex08;

public class Main {
    public static void main() {
        Produto camisa = new Produto("Camisa listrada", 20.50, 0);
        Produto casaco = new Produto("OverCoat", 70, 0);
        Produto vestido = new Produto("Vestido preto", 30.50, 0);

        camisa.adquirirStock(20);
        casaco.adquirirStock(10);
        vestido.adquirirStock(2);

        camisa.venderProduto(10);

        vestido.setPreco(20);

        vestido.venderProduto(2);

        System.out.println("Stock camisa: "+camisa.getQuantidadeStock());
        System.out.println("Stock casaco: "+casaco.getQuantidadeStock());
        System.out.println("Stock vestido: "+vestido.getQuantidadeStock());

    }
}
