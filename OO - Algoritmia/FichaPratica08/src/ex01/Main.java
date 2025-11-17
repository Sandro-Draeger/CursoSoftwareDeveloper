package ex01;

public class Main {
    public static void main(String[] args){
        Pessoa pessoa1 = new Pessoa("Sandro", 29, 1.86);
        Pessoa pessoa2 = new Pessoa("Arícia", 31, 1.62);
        System.out.println("Nome: " + pessoa1.getNome() + "\nIdade: " + pessoa1.getIdade() + "\nAltura: " + pessoa1.getAltura());
        System.out.println("\nNome: " + pessoa2.getNome() + "\nIdade: " + pessoa2.getIdade() + "\nAltura: " + pessoa2.getAltura());
    }
}
