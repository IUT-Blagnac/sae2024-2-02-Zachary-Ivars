package iut.sae.algo;


public class Simplicite {
    public static String RLE(String input) {
        String output = "";
        int nombreDeLettres = 1;
        int taille = input.length();
        for (int i = 0; i < taille; i++) {
            if (i == taille - 1) {
                output = output + nombreDeLettres + input.charAt(i);
            } else if (input.charAt(i) != input.charAt(i + 1)) {
                output = output + nombreDeLettres + input.charAt(i);
                nombreDeLettres = 1;
            } else if (nombreDeLettres == 9){
                output = output + nombreDeLettres + input.charAt(i);
                nombreDeLettres = 1;
            } else {
                nombreDeLettres = nombreDeLettres + 1;
            }
        }
        return output;
    }
    

    public static String RLE(String input, int iteration) throws AlgoException{
        if(iteration <= 1){
            return RLE(input);
        } else {
            return RLE(RLE(input, iteration-1));
        }
    }

    public static String unRLE(String input) throws AlgoException{
        String output = "";
        int nombreDeLettres;
        int taille = input.length();
        char c;
        for (int i = 0; i < taille; i+=2) {
            c = input.charAt(i+1);
            nombreDeLettres = Integer.parseInt(String.valueOf(input.charAt(i)));
            for (int j = 0; j < nombreDeLettres; j++) {
                output = output + String.valueOf(c);
            }
        }
        return output;
    }

    public static String unRLE(String input, int iteration) throws AlgoException{
        if(iteration <= 1){
            return unRLE(input);
        } else {
            return unRLE(unRLE(input, iteration-1));
        }
    }
}

