package iut.sae.algo.Algotest.Sobriete;

import iut.sae.algo.AlgoException;

public class Algo51sobriete{
    public static String RLE(String in) {
        if (in == null || in.isEmpty()) {
            return "";
        }

        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 0; i < in.length(); i++) {
            char currentChar = in.charAt(i);
            int j = i + 1;
            while (j < in.length() && in.charAt(j) == currentChar) {
                count++;
                j++;
            }
            encoded.append(count).append(currentChar);
            count = 1;
            i = j - 1;
        }

        return encoded.toString();
    }
    

    public static String RLE(String in, int iteration) throws AlgoException{
        for (int i = 0; i < iteration; i++){
            in = RLE(in);
        }
        return in;
    }

    public static String unRLE(String in) throws AlgoException{
        StringBuilder decoded = new StringBuilder();

        for (int i = 0; i < in.length(); i +=2){
            int val = in.charAt(i) - '0';
            char car = in.charAt(i+1);
            for (int j = 0; j < val; j++){
                decoded.append(car);
            }
        }
        return decoded.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        for (int i = 0 ; i < iteration; i ++){
            in = unRLE(in);
        }
        return in;
    }
}

