package iut.sae.algo;

import java.util.Scanner;

public class RLERecursifConsole {

    public static void main(String[] args) throws AlgoException {
        String in = "";
        int iterations = 1;

        if (args.length >= 2) {
            in = args[0];
            iterations = Integer.valueOf(args[1]);
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Chaine à transformer : ");
            in = scanner.next();

            System.out.println("Nombre d'itérations : ");
            iterations = scanner.nextInt();

            scanner.close();
        }

        System.out.println("Entrée : " + in);
        System.out.println("Itérations : " + iterations);

        long startTime = System.currentTimeMillis();
        System.out.println("Sortie : " + efficacite04.RLE(in, iterations));
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Temps d'exécution en millisecondes : " + executionTime);
    }
}