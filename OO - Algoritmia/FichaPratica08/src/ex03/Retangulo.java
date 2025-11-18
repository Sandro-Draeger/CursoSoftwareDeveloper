package ex03;

public class Retangulo {
    private String cor;
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public Retangulo(String cor, double largura, double altura) {
        this.cor = cor;
        this.largura = largura;
        this.altura = altura;
    }
    public double perimetro(){
        return this.largura+this.altura+this.largura+this.altura;
    }
    public double area(){
        return this.largura * this.altura;
    }
}
