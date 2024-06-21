package iut.sae.algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe contenant des méthodes simples pour l'encodage et le décodage selon l'algorithme Run-Length Encoding (RLE).
 */
public class simplicite57 {

    /**
     * Méthode RLE pour compresser une chaîne selon l'algorithme Run-Length Encoding.
     * @param in Chaîne à compresser
     * @return Chaîne compressée en utilisant RLE
     */
    public static String RLE(String in) {
        if (in == null || in.isEmpty()) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        StringBuilder sb = new StringBuilder();
        char currentChar = in.charAt(0);
        int count = 1;

        // Parcourt la chaîne d'entrée à partir du deuxième caractère
        for (int i = 1; i < in.length(); i++) {
            if (in.charAt(i) == currentChar) {
                count++;  // Incrémente le compteur si le caractère est le même que le précédent
            } else {
                // Ajoute le nombre d'occurrences et le caractère au StringBuilder
                appendRLE(sb, count, currentChar);
                currentChar = in.charAt(i);  // Met à jour le caractère courant
                count = 1;  // Réinitialise le compteur pour le nouveau caractère
            }
        }

        // Ajoute le dernier groupe de caractères à la fin de la boucle
        appendRLE(sb, count, currentChar);

        return sb.toString();  // Retourne la chaîne compressée
    }

    /**
     * Méthode unRLE pour décompresser une chaîne compressée par RLE.
     * @param in Chaîne compressée avec RLE
     * @return Chaîne décompressée
     * @throws AlgoException Si le format d'entrée est invalide
     */
    public static String unRLE(String in) throws AlgoException {
        if (in == null || in.isEmpty()) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d+|\\D");  // Pattern pour trouver les séquences de chiffres ou de non-chiffres
        Matcher matcher = pattern.matcher(in);

        // Parcourt la chaîne d'entrée en utilisant un Matcher
        while (matcher.find()) {
            String token = matcher.group();  // Récupère le groupe de chiffres ou de non-chiffres
            if (Character.isDigit(token.charAt(0))) {
                int count = Integer.parseInt(token);  // Convertit le nombre de répétitions en entier
                if (count < 1) {
                    throw new AlgoException("Invalid input format");
                }
                appendUnRLE(sb, count, matcher);  // Répète le caractère suivant le nombre de fois spécifié
            } else {
                sb.append(token);  // Ajoute directement le caractère non-chiffre au StringBuilder
            }
        }

        return sb.toString();  // Retourne la chaîne décompressée
    }

    /**
     * Méthode RLE avec itération.
     * @param in Chaîne à compresser initialement
     * @param iteration Nombre d'itérations d'encodage RLE à appliquer
     * @return Chaîne compressée après les itérations
     * @throws AlgoException Si le nombre d'itérations est inférieur à 1
     */
    public static String RLE(String in, int iteration) throws AlgoException {
        if (iteration < 1) {
            throw new AlgoException("Iteration count must be at least 1");
        }

        String result = in;
        for (int i = 0; i < iteration; i++) {
            result = RLE(result);  // Applique l'encodage RLE à chaque itération
        }

        return result;
    }

    /**
     * Méthode unRLE avec itération.
     * @param in Chaîne à décompresser initialement
     * @param iteration Nombre d'itérations de décodage RLE à appliquer
     * @return Chaîne décompressée après les itérations
     * @throws AlgoException Si le nombre d'itérations est inférieur à 1
     */
    public static String unRLE(String in, int iteration) throws AlgoException {
        if (iteration < 1) {
            throw new AlgoException("iteration doit etre superieur a 1");
        }

        String result = in;
        for (int i = 0; i < iteration; i++) {
            result = unRLE(result);  // Applique le décodage RLE à chaque itération
        }

        return result;
    }

    /**
     * Méthode pour ajouter une séquence RLE au StringBuilder, en tenant compte des répétitions de 9.
     * @param sb StringBuilder où ajouter la séquence encodée
     * @param count Nombre de répétitions du caractère
     * @param currentChar Caractère à répéter
     */
    private static void appendRLE(StringBuilder sb, int count, char currentChar) {
        while (count > 0) {
            if (count > 9) {
                sb.append(9);  // Ajoute 9 si la répétition est supérieure à 9
                sb.append(currentChar);
                count -= 9;
            } else {
                sb.append(count);  // Ajoute le nombre restant de répétitions
                sb.append(currentChar);
                count = 0;
            }
        }
    }

    /**
     * Méthode pour ajouter une séquence unRLE au StringBuilder.
     * @param sb StringBuilder où ajouter la séquence décodée
     * @param count Nombre de répétitions du caractère
     * @param matcher Matcher pour récupérer le caractère à répéter
     */
    private static void appendUnRLE(StringBuilder sb, int count, Matcher matcher) {
        String token = matcher.group();
        char c = token.charAt(token.length() - 1);
        while (count > 0) {
            if (count > 9) {
                sb.append(c);  // Ajoute le caractère s'il y a une répétition de 9
                count -= 9;
            } else {
                sb.append(String.valueOf(c).repeat(count));  // Répète le caractère le nombre de fois spécifié
                count = 0;
            }
        }
    }
}
