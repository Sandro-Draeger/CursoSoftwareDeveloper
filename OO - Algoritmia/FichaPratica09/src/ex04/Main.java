package ex04;

public class Main {
    static void main() {
        Imovel casa = new Imovel("Avenida Artrio", 50, "Porto", Tipo.CASA, Acabamento.NOVA_COM_ALTO_ACABAMENTO, 100, 15, 4, 2);
        Imovel apto = new Imovel("Rua Genésio", 160, "Povoa Varzim", Tipo.APARTAMENTO, Acabamento.USADA, 90, 0, 2, 2);

        System.out.println(casa.calcularValor());
        System.out.println(apto.calcularValor());

        System.out.println(casa.compararImoveis(apto));
    }
}
