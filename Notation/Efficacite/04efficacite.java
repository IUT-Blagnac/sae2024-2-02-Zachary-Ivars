package iut.sae.algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class efficacite {
    
    public static String RLE(String in){
        if (in.isEmpty()) {
            return "";
        }

       StringBuilder sb = new StringBuilder();
        // On lit les caractères puis on cherche les occurrences consécutives de cette même lettre grâce au \\2*
        Pattern pattern = Pattern.compile("(([a-zA-Z])\\2*)");
        Matcher matcher = pattern.matcher(in);

        while (matcher.find()) {
            int rep = matcher.group(1).length();

            if (rep > 9) {
                while (rep > 9) {
                    sb.append(9).append(matcher.group(2));
                    rep -= 9;
                }
            }
            sb.append(rep).append(matcher.group(2));
        }
        return sb.toString();

    }

    public static String RLE(String in, int iteration) {
        if (iteration <= 0 || in.isEmpty()) {
            return in;
        }
        
        for (int i = 0; i < iteration; i++) {
            in = RLE(in);
        }
        
        return in;
    }

    public static String unRLE(String in) throws AlgoException{
        if (in.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < in.length(); i++) {
            int cpt = in.charAt(i) - '0'; // Convertir le caractère numérique en valeur entière
            char caractere = in.charAt(++i);
            for (int j = 0; j < cpt; j++) {
                sb.append(caractere);
            }
        }
        return sb.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        String resultat = in;
        for (int i = 0; i < iteration; i++) {
            resultat = unRLE(resultat);
        }
        return resultat;

    }
}