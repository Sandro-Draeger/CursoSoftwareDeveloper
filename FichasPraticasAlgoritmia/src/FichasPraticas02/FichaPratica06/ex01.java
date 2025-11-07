package FichasPraticas02.FichaPratica06;

import java.util.Scanner;

public class ex01 {


    public static void fazerBarulho(String animal) {
        switch (animal) {
            case "cao":
                System.out.println("Au au au");
                break;
            case "gato":
                System.out.println("Miau");
                break;
            case "peixe":
                System.out.println("Glub! Glub!");
                break;
            case "vaca":
                System.out.println("Muuuu");
                break;
            case "porco":
                System.out.println("Oinc Oinc");
                break;
            default:
                System.out.println("não encontrado");
        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String animalInput;

        System.out.print("Digite um animal: ");
        animalInput = input.nextLine();

        fazerBarulho(animalInput);
    }

}