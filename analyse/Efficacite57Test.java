package iut.sae.algo;

import org.junit.Test;
import junit.framework.TestCase;


public class Efficacite57Test extends TestCase{

/*
 * RLE("")=""
 * RLE("abc")="1a1b1c"
 * RLE("abbccc")="1a2b3c"
 * RLE("aaabaa")="3a1b2a"
 * RLE("aAa")="1a1A1a"
 */
   @Test
   public void testRLE(){
      assertEquals("", efficacite57.RLE("") );
      
      assertEquals("1a2b3c", efficacite57.RLE("abbccc"));
      assertEquals("3a1b2a", efficacite57.RLE("aaabaa"));
      assertEquals("1a1A1a", efficacite57.RLE("aAa"));
      assertEquals("9W4W", efficacite57.RLE("WWWWWWWWWWWWW"));

   }


     /*
     * RLE(str, 1)=RLE(str)
     * RLE(str, 3)=RLE(RLE(RLE(str)))
     */
    @Test
    public void testRLERecursif(){
        try{
            assertEquals("", efficacite57.RLE("", 1));
            assertEquals("", efficacite57.RLE("", 3));

            assertEquals("1a1b1c", efficacite57.RLE("abc", 1));
            assertEquals("1a2b3c", efficacite57.RLE("abbccc", 1));
            assertEquals("3a1b2a", efficacite57.RLE("aaabaa", 1));
            assertEquals("1a1A1a", efficacite57.RLE("aAa", 1));

            assertEquals("111a111b111c", (efficacite57.RLE("abc", 2))); // FAILED BY : efficacite04;
            assertEquals("311a311b311c", (efficacite57.RLE("abc", 3))); // FAILED BY : efficacite04;

            String saeIte20="1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211S1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211E1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211_1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211l1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211g1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211o";
             assertEquals(saeIte20, efficacite57.RLE("SAE_Algo", 20)); // FAILED BY : efficacite04;
          }
          catch(Exception e){
             fail("Exception inatendue");
          }
       }

   /*
  * unRLE(RLE(str))=str
  *
  * unRLE("")=""
  * unRLE("1a1b1c")="abc"
  * unRLE("1a2b3c")="abbccc"
  * unRLE("3a1b2a")="aaabaa"
  * unRLE("1a1A1a")="aAa"
  */

   @Test
   public void testUnRLE(){
      try{
         assertEquals("", efficacite57.unRLE(""));
         assertEquals("abc", efficacite57.unRLE("1a1b1c"));
         assertEquals("abbccc", efficacite57.unRLE("1a2b3c"));
         assertEquals("aaabaa", efficacite57.unRLE("3a1b2a"));
         assertEquals("aAa", efficacite57.unRLE("1a1A1a"));
         assertEquals("WWWWWWWWWWWWW", efficacite57.unRLE("9W4W"));
      }
      catch(Exception e){
         fail("Exception inatendue");
      }
   }
   
   @Test
   public void testUnRLERecursif(){
      try{
         assertEquals("", efficacite57.unRLE("", 1));
         assertEquals("", efficacite57.unRLE("", 3));
         
         assertEquals("abc", efficacite57.unRLE("1a1b1c", 1));
         assertEquals("abbccc", efficacite57.unRLE("1a2b3c", 1));
         assertEquals("aaabaa", efficacite57.unRLE("3a1b2a", 1));
         assertEquals("aAa", efficacite57.unRLE("1a1A1a", 1));

         assertEquals("abc", (efficacite57.unRLE("111a111b111c", 2))); // Exception raised : efficacite57;
         assertEquals("abc", (efficacite57.unRLE("311a311b311c", 3))); // Exception raised : efficacite57;
      }
      catch(AlgoException e){
         fail("Exception inatendue");
      }
   }

}

/** This part will be for the number of fails/exceptions per class "efficacite" : 
 *  - efficacite04 : 3 fails             — respect des noms de fonctions
 *  - efficacite12 : 0                   — non respect des noms de fonctions (unRLE_Recursif, RLE_Recursif)
 *  - efficacite44 : 0                   — respect des noms de fonctions
 *  - efficacite46 : 0                   — respect des noms de fonctions
 *  - efficacite57 : 2 exceptions raised — respect des noms de fonctions
 */