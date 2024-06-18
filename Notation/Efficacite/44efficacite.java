package iut.sae.algo;


public class Efficacite{

    /* Méthode RLE efficacite
     * 
     * Avec un String builder, plutôt que de concaténer des chaînes de caractères
     */
    public static String RLE(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
    
        char[] chars = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 1;
    
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                if (count == 9) {
                    result.append(9).append(chars[i - 1]);
                    count = 1;
                } else {
                    count++;
                }
            } else {
                result.append(count).append(chars[i - 1]);
                count = 1;
            }
        }
    
        result.append(count).append(chars[chars.length - 1]);
        return result.toString();
    }
    


    public static String RLE(String in, int iteration) throws AlgoException {
        // On vérifie si la chaîne d'entrée est vide
        if (in == null || in.isEmpty()) {
            return "";
        }

        // On vérifie si l'itération est valide
        if (iteration < 1) {
            throw new AlgoException("L'itération doit être supérieure à 0");
        }

        // On fait l'itération
        for (int i = 0; i < iteration; i++) {
            in = RLE(in);
        }

        return in;
    }


    public static String unRLE(String in) throws AlgoException {
        if (in == null || in.isEmpty()) {
            return "";
        }
    
        char[] chars = in.toCharArray();
        StringBuilder chaineFinale = new StringBuilder();
        int cpt = 0;
    
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                cpt = chars[i] - '0';
                for (int j = 0; j < cpt; j++) {
                    chaineFinale.append(chars[i + 1]);
                }
                i++; // Passer au caractère suivant
            }
        }
    
        return chaineFinale.toString();
    }



    public static String unRLE(String in, int iteration) throws AlgoException {

        for (int i = 0; i < iteration; i++) {
            in = unRLE(in);
        }

        return in;
    }
}

