package iut.sae.algo;


public class Efficacite{
    public static String RLE(String in){
        String out = "";
        int nbrLettres = 1;
        int taille = in.length();
        for (int i = 0; i < taille; i++) {
            if (i == taille-1) out = out + nbrLettres + in.charAt(i);
            else if (in.charAt(i) != in.charAt(i+1)) {
                out = out + nbrLettres + in.charAt(i);
                nbrLettres = 1;
            } else if (nbrLettres == 9) {
                out = out + nbrLettres + in.charAt(i);
                nbrLettres = 1;
            } else {
                nbrLettres++;
            }
        }
        return out;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        if(iteration <= 1){
            return RLE(in);
        } else {
            return RLE(RLE(in, iteration-1));
        }
    }

    public static String unRLE(String in) throws AlgoException{
        String out = "";
        int nbrLettres;
        int taille = in.length();
        char c;
        for (int i = 0; i < taille; i+=2) {
            c = in.charAt(i+1);
            nbrLettres = Integer.parseInt(String.valueOf(in.charAt(i)));
            for (int j = 0; j < nbrLettres; j++) {
                out = out + in.charAt(i+1);
            }
        }
        return out;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if(iteration <= 1){
            return unRLE(in);
        } else {
            return unRLE(unRLE(in, iteration-1));
        }
    }
}