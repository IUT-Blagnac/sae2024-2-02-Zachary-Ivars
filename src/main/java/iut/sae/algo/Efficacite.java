package iut.sae.algo;


public class Efficacite{
    public static String RLE(String in) {
        StringBuilder out = new StringBuilder();
        int nbrLettres = 1;
        int taille = in.length();
        for (int i = 0; i < taille; i++) {
            if (i == taille - 1) {
                out.append(nbrLettres).append(in.charAt(i));
            } else if (in.charAt(i) != in.charAt(i + 1) || nbrLettres == 9) {
                out.append(nbrLettres).append(in.charAt(i));
                nbrLettres = 1;
            } else {
                nbrLettres++;
            }
        }
        return out.toString();
    }
    

    public static String RLE(String in, int iteration) throws AlgoException{
        if(iteration <= 1){
            return RLE(in);
        } else {
            return RLE(RLE(in, iteration-1));
        }
    }

    public static String unRLE(String in) throws AlgoException{
        StringBuilder out = new StringBuilder();
        int nbrLettres;
        int taille = in.length();
        char c;
        for (int i = 0; i < taille; i+=2) {
            c = in.charAt(i+1);
            nbrLettres = Integer.parseInt(String.valueOf(in.charAt(i)));
            for (int j = 0; j < nbrLettres; j++) {
                out.append(c);
            }
        }
        return out.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if(iteration <= 1){
            return unRLE(in);
        } else {
            return unRLE(unRLE(in, iteration-1));
        }
    }
}

