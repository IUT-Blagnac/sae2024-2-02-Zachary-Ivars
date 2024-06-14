package iut.sae.algo;

import java.util.Scanner;

public class RLEConsole{

    public static void main(String[] args) throws AlgoException{
        String in="";
        
        if(args.length>0){
            in=args[0];
        }
        else{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Chaine à transformer : ");
            in = scanner.next();

            scanner.close();
        }

        System.out.println("Entrée : "+in);
        System.out.println("Sortie : "+ Efficacite.RLE(in));

        System.out.println("\n——————————\nMaintenant il faut faire le décompresser, essayons : ");

        System.out.println("Entrée : "+Efficacite.RLE(in));
        System.out.println("Sortie : " + Efficacite.unRLE(Efficacite.RLE(in)));
    }
}