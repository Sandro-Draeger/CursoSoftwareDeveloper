package ex05;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private int anoFabrico;

    public Carro(String marca, String modelo, String cor, int anoFabrico) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getCor() {
        return this.cor;
    }

    public int getAnoFabrico() {
        return this.anoFabrico;
    }

    public String ligarCarro(){
        System.out.println("O carro "+marca+" "+modelo+" "+cor+" "+anoFabrico+", está ligado!" );

        return null;
    }
}
