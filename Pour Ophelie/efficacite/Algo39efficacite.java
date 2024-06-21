package iut.sae.algo.Algotest.Efficacite;

import iut.sae.algo.AlgoException;

public class Algo39efficacite{
    public static String RLE(String in) {
        if (in == null || in.length() == 0) {
            return "";
        }

        StringBuilder sortie = new StringBuilder();
        char charPrecedent = in.charAt(0);
        int nbRep = 1;

        for (int i = 1; i < in.length(); i++) {
            if (in.charAt(i) == charPrecedent) {
                nbRep++;
                if (nbRep == 9) {
                    sortie.append(nbRep).append(charPrecedent);
                    nbRep = 0;
                }
            } else {
                sortie.append(nbRep).append(charPrecedent);
                charPrecedent = in.charAt(i);
                nbRep = 1;
            }
        }
        sortie.append(nbRep).append(charPrecedent);

        return sortie.toString();
    }


    public static String RLE(String in, int iteration) throws AlgoException{
        if (iteration <= 0 || in == null || in.length() == 0) {
            return in;
        }

        String sortie = in;
        for (int i = 0; i < iteration; i++){
            sortie = RLE(sortie);
        }
        return sortie;
    }

    public static String unRLE(String in) throws AlgoException {
        if (in == null || in.length() == 0) {
            return "";
        }
    
        StringBuilder sortie = new StringBuilder();
    
        for (int i = 0; i < in.length(); i += 2) {
            int nbRep = Character.getNumericValue(in.charAt(i));
            char charPrecedent = in.charAt(i + 1);
    
            for (int j = 0; j < nbRep; j++) {
                sortie.append(charPrecedent);
            }
        }
    
        return sortie.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if (iteration <= 0 || in == null || in.length() == 0) {
            return in;
        }
        
        String sortie = in;
        for (int i = 0; i < iteration; i++){
            sortie = unRLE(sortie);
        }
        return sortie;
    }
}