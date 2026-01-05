package ex08;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeStock = 0;

    public Produto(String nome, double preco, int quantidadeStock) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeStock() {
        return quantidadeStock;
    }

    public int adquirirStock(int novoProduto) {
        this.quantidadeStock = this.quantidadeStock + novoProduto;
        System.out.println("Produto adicionado ao Stock!");
        return this.quantidadeStock;
    }

    public int venderProduto(int venda) {
        if (this.quantidadeStock < venda) {
            System.out.println("Não há stock suficiente!");
        } else {
            this.quantidadeStock = this.quantidadeStock - venda;
            System.out.println("Compra realizada com sucesso!");

        }
        return this.quantidadeStock;
    }
}
