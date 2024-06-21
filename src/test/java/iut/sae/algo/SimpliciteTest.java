package iut.sae.algo;

import org.junit.Test;
import junit.framework.TestCase;


public class SimpliciteTest extends TestCase{

/*
 * RLE("")=""
 * RLE("abc")="1a1b1c"
 * RLE("abbccc")="1a2b3c"
 * RLE("aaabaa")="3a1b2a"
 * RLE("aAa")="1a1A1a"
 */
   @Test
   public void testRLE(){
      assertEquals("", simplicite68.RLE("") );
      
       assertEquals("1a2b3c", simplicite68.RLE("abbccc"));
      assertEquals("3a1b2a", simplicite68.RLE("aaabaa"));
      assertEquals("1a1A1a", simplicite68.RLE("aAa"));
      assertEquals("9W4W", simplicite68.RLE("WWWWWWWWWWWWW"));

   }


     /*
     * RLE(str, 1)=RLE(str)
     * RLE(str, 3)=RLE(RLE(RLE(str)))
     */
    @Test
    public void testRLERecursif(){
        try{
            assertEquals("", simplicite68.RLE("", 1));
            assertEquals("", simplicite68.RLE("", 3));

            assertEquals("1a1b1c", simplicite68.RLE("abc", 1));
            assertEquals("1a2b3c", simplicite68.RLE("abbccc", 1));
            assertEquals("3a1b2a", simplicite68.RLE("aaabaa", 1));
            assertEquals("1a1A1a", simplicite68.RLE("aAa", 1));

            assertEquals("111a111b111c", (simplicite68.RLE("abc", 2)));
            assertEquals("311a311b311c", (simplicite68.RLE("abc", 3)));

            String saeIte20="1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211S1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211E1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211_1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211l1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211g1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211o";
             assertEquals(saeIte20, simplicite68.RLE("SAE_Algo", 20));
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
         assertEquals("", simplicite68.unRLE(""));
         assertEquals("abc", simplicite68.unRLE("1a1b1c")); // Failed by : simplicite57;
         assertEquals("abbccc", simplicite68.unRLE("1a2b3c")); // Failed by : simplicite57;
         assertEquals("aaabaa", simplicite68.unRLE("3a1b2a")); // Failed by : simplicite57;
         assertEquals("aAa", simplicite68.unRLE("1a1A1a")); // Failed by : simplicite57;
        assertEquals("WWWWWWWWWWWWW", simplicite68.unRLE("9W4W")); // Failed by : simplicite57;
      }
      catch(Exception e){
         fail("Exception inatendue");
      }
   }
   
   @Test
   public void testUnRLERecursif(){
      try{
         assertEquals("", simplicite68.unRLE("", 1));
         assertEquals("", simplicite68.unRLE("", 3));
         
         assertEquals("abc", simplicite68.unRLE("1a1b1c", 1)); // Failed by : simplicite57;
         assertEquals("abbccc", simplicite68.unRLE("1a2b3c", 1)); // Failed by : simplicite57;
         assertEquals("aaabaa", simplicite68.unRLE("3a1b2a", 1)); // Failed by : simplicite57;
         assertEquals("aAa", simplicite68.unRLE("1a1A1a", 1)); // Failed by : simplicite57;

         assertEquals("abc", (simplicite68.unRLE("111a111b111c", 2))); // Failed by : simplicite57;
         assertEquals("abc", (simplicite68.unRLE("311a311b311c", 3))); // Failed by : simplicite57;
      }
      catch(Exception e){
         fail("Exception inatendue");
      }
   }

}

/** This part will be for the number of fails/exceptions per class "simplicite" : 
 *  - simplicite45 : 0
 *  - simplicite48 : 0
 *  - simplicite57 : 11 tests failed
 *  - simplicite61 : 2 tests failed
 *  - simplicite68 : 0
 */