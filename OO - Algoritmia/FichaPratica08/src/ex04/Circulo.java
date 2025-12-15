package ex04;

public class Circulo {
    private String cor;
    private double raio;


    public Circulo(String cor, double raio) {
        this.cor = cor;
        this.raio = raio;
    }

    public String getCor() {
        return cor;
    }

    public double getRaio() {
        return raio;
    }

    public double perimetro(){
        return this.raio*3.14*2;
    }
    public double area(){
        return (this.raio*this.raio)*3.14;
    }
}

