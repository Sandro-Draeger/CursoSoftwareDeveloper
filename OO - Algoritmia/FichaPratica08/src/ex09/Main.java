package ex09;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;

public class Main {
    static void main() {
        Funcionario gerson = new Funcionario("Gerson", "email@gmail.com", "RH", 1500);

        System.out.println(gerson.getNome());
        System.out.println(gerson.getEmail());
        System.out.println(gerson.getDepartamento());
        System.out.println(gerson.getSalario());

        gerson.aumentarSalario(80);

        System.out.println(gerson.getSalario());
    }
}