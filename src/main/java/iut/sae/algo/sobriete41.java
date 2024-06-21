package iut.sae.algo;


public class sobriete41{
    public static String RLE(String in){
        if (in.isEmpty() || in == null)
            return "";

        int length, i, ctChar;
        char currentChar, chars[]; 
        
        
        StringBuilder out = new StringBuilder();

        chars = in.toCharArray();
        length = chars.length;
        currentChar = chars[0]; 
        ctChar = 1; // Compte le nombre d'une lettre
        

        for ( i = 1 ; i < length ; i++ ){
            if ( currentChar != in.charAt(i) || ctChar >= 9 ){
                out.append(ctChar).append(currentChar);
                currentChar = chars[i];
                ctChar = 1;
            } else{
                ctChar++;
            }
        }
        out.append(ctChar).append(currentChar);
        return out.toString();
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        if (iteration < 1)
            throw new AlgoException("Erreur: L'itération ne doit pas être inférieur à 1");
        
        String out = in; 
        for (int i = 0 ; i < iteration ; i++ ){
            out = RLE(out);
        }
        return out;
    }

    public static String unRLE(String in) throws AlgoException{
        if (in.isEmpty() || in == null) 
            return "";
            
        int length, i, j, ctChar;
        char chars[]; 
        
        StringBuilder out = new StringBuilder();

        chars = in.toCharArray();
        length = chars.length-1;
        ctChar = 1; // Compte le nombre d'une lettre


        for ( i = 0 ; i < length ; i+=2 ){
            ctChar = Character.getNumericValue(chars[i]);
                for ( j = 0 ; j < ctChar ; j++ ){
                    out.append(chars[i+1]);
                }              
        }
        return out.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if (iteration < 1)
            throw new AlgoException("Erreur: L'itération ne doit pas être inférieur à 1");
        
        String out = in;
        
        for (int i = 0 ; i < iteration ; i++ ){
            out = unRLE(out);
        }
        return out;

    }
}

