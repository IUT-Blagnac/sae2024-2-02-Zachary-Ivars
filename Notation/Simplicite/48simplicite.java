package iut.sae.algo;

public class Algo{
    public static String RLE(String in){
        String msg="";
        if(in==""){
            return msg;
        }
        char pre_caract=in.charAt(0);
        int nb_caract=1;
        int i=1;
        while(i<in.length()){
            if(in.charAt(i)==pre_caract){
                if(nb_caract==9){
                    msg=msg+nb_caract+pre_caract;
                    nb_caract=0;
                }
                nb_caract++;
            }else{
                msg=msg+nb_caract+pre_caract;
                pre_caract=in.charAt(i);
                nb_caract=1;
            }
            i++;
        }
        msg=msg+nb_caract+pre_caract;
        return msg;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        String msg="";
        if(in=="" || iteration==0){
        }else if(iteration==1){
            msg=RLE(in);
        }else{
            String res=RLE(in,iteration-1);
            msg=RLE(res);
        }
        return msg;
    }

    public static String unRLE(String in) throws AlgoException{
        String msg="";
        int i=0;
        while(i<in.length()-1){
            int nb_char=in.charAt(i);
            int nb_int=nb_char-'0';
            i++;
            char carac=in.charAt(i);
            i++;
            int j=0;
            while(j<nb_int){
                msg=msg+carac;
                j++;
            }
        }
        return msg;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        String msg="";
        if(in=="" || iteration==0){
        }else if(iteration==1){
            msg=unRLE(in);
        }else{
            String res=unRLE(in,iteration-1);
            msg=unRLE(res);
        }
        return msg;
    }
}