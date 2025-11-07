package FichasPraticas01;

import java.util.Scanner;

public class ex08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int minuto, segundo, albumHora, albumMinuto, albumSegundo;

        System.out.println("introduza os minutos da música 1: ");
        minuto = input.nextInt();

        System.out.println("introduza os segundos da música 1: ");
        segundo = input.nextInt();

        int[] m1 = {segundo, minuto};

        System.out.println("introduza os minutos da música 2: ");
        minuto = input.nextInt();

        System.out.println("introduza os segundos da música 2: ");
        segundo = input.nextInt();

        int[] m2 = {segundo, minuto};

        System.out.println("introduza os minutos da música 3: ");
        minuto = input.nextInt();

        System.out.println("introduza os segundos da música 3: ");
        segundo = input.nextInt();

        int[] m3 = {segundo, minuto};

        System.out.println("introduza os minutos da música 4: ");
        minuto = input.nextInt();

        System.out.println("introduza os segundos da música 4: ");
        segundo = input.nextInt();

        int[] m4 = {segundo, minuto};

        System.out.println("introduza os minutos da música 5: ");
        minuto = input.nextInt();

        System.out.println("introduza os segundos da música 5: ");
        segundo = input.nextInt();

        int[] m5 = {segundo, minuto};


        albumMinuto = (m1[1] + m2[1] + m3[1] + m4[1] + m5[1]) * 60;
        albumSegundo = (m1[0] + m2[0] + m3[0] + m4[0] + m5[0]) + albumMinuto;

        albumHora = albumSegundo / 3600;
        albumMinuto = (albumSegundo / 60) - (albumHora * 60);
        albumSegundo = albumSegundo - (albumHora * 3600) - (albumMinuto * 60);


        System.out.println("Tempo total do album: " + albumHora + ":" + albumMinuto + ":" + albumSegundo);


    }
}
