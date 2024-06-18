package iut.sae.algo;

public class Simplicite {

    public static String RLE(String in) {
        int compteur = 0; //compteur d'occurence
        int cpt = 0; //compteur de caractère
        String out = ""; //chaine de caractère de sortie

        if (in.isEmpty()) { //si la chaine est vide, on retourne une chaine vide
            return "";
        }

        for (int i = 0; i < in.length(); i += cpt) { //parcours de la chaine
            char c = in.charAt(i);
            compteur = 1;
            cpt = 1;
            while (i+cpt < in.length() && in.charAt(i+cpt) == c) { //comptage des occurences
                compteur++;
                cpt++;
                if (compteur == 10) { //si le compteur atteint 10, on remet le compteur à 1 et on ajoute le caractère
                    out = out + "9" + c;
                    compteur = 1;
                }
            }
            out = out + compteur + c;
        }
        return out; //retourne la chaine compressée
    }


    public static String RLE(String in, int iteration) throws AlgoException{
        String out = ""; //chaine de caractère de sortie

        if (iteration == 1) { //si l'itération est égale à 1, on retourne la chaine compressée
            return RLE(in);
        }

        for (iteration = iteration ; iteration > 0; iteration--) { //sinon on compresse la chaine autant de fois que l'itération
            out = RLE(in); //on compresse la chaine
            in = out; //on remplace la chaine d'entrée par la chaine compressée
        }

        return out; //retourne la chaine compressée
    }




    public static String unRLE(String in) throws AlgoException{
        int compteur = 0; //compteur d'occurence
        String out = ""; //chaine de caractère de sortie

        if (in.isEmpty()) { //si la chaine est vide, on retourne une chaine vide
            return "";
        }

        for (int i = 0; i < in.length(); i += 2) { //parcours de la chaine
            compteur = Character.getNumericValue(in.charAt(i)); //récupération du nombre d'occurence
            for (int j = 0; j < compteur; j++) { //ajout du caractère autant de fois que le nombre d'occurence
                out = out + in.charAt(i+1);
            }
        }
        return out; //retourne la chaine décompressée

    }

    
    public static String unRLE(String in, int iteration) throws AlgoException{
        String out = ""; //chaine de caractère de sortie

        if (iteration == 1) { //si l'itération est égale à 1, on retourne la chaine décompressée
            return unRLE(in);
        }

        for (iteration = iteration ; iteration > 0; iteration--) { //sinon on décompresse la chaine autant de fois que l'itération
            out = unRLE(in); //on décompresse la chaine
            in = out; //on remplace la chaine d'entrée par la chaine décompressée
        }

        return out; //retourne la chaine décompressée
    }
}
