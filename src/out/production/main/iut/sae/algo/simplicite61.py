import unittest # ajout de l'import par ZI

class Simplicite:

    def RLE(texte):
        # on initialise la première lettre et le compteur
        lettre = texte[0]
        chaine_finale = ""
        compteur_lettre = 0

        # on parcours chaque parametre de la chaine
        for i in range(len(texte)):
            # si le caractère actuel est le même que le précédent et que le compteur est inférieur à 9
            if lettre == texte[i] and compteur_lettre < 9:
                # incrémenter le compteur
                compteur_lettre = compteur_lettre + 1
            else:
                # on ajoute le compteur et la lettre à la chaîne finale
                chaine_finale = chaine_finale + str(compteur_lettre) + lettre
                # on réinitialise le compteur et mettre à jour la lettre
                compteur_lettre = 1
                lettre = texte[i]

            # si le compteur atteint 9 (ce qu'il ne faut pas)
            if compteur_lettre == 9:
                # on ajoute le compteur et la lettre à la chaîne finale
                chaine_finale = chaine_finale + str(compteur_lettre) + lettre
                # si on est pas à la fin de la chaîne
                if i < len(texte) - 1:
                    # on mets à jour la lettre
                    lettre = texte[i+1]
                # on reinitialise le compteur
                compteur_lettre = 0

        # si le compteur est supérieur à 0 à la fin de la boucle
        if compteur_lettre > 0:
            # on ajoute ce qu'il reste a la chaine finale
            chaine_finale = chaine_finale + str(compteur_lettre) + lettre

        # on retourne la chaîne finale
        return chaine_finale

    def RLE_recursif(chaine,nombre):
        # on repete le processus le nombre de fois spécifié
        for i in range(nombre):
            chaine = Simplicite.RLE(chaine) # ajout de Simplicite. par ZI
        return chaine


    def unRLE(chaine):
        result = ""
        for i in range(0, len(chaine), 2):
            nombre = int(chaine[i])
            caractere = chaine[i+1]
            result += caractere * nombre
        return result

    def unRLE_recursif(chaine, nombre):
        resultat = chaine
        for i in range(nombre):
            resultat = Simplicite.unRLE(resultat) # ajout de Simplicite. par ZI
        return resultat

class SimpliciteTest(unittest.TestCase): # ajout de la classe de test par ZI

    def test_RLE(self):
        self.assertEqual(Simplicite.RLE(""), "")
        self.assertEqual(Simplicite.RLE("abc"), "1a1b1c")
        self.assertEqual(Simplicite.RLE("abbccc"), "1a2b3c")
        self.assertEqual(Simplicite.RLE("aaabaa"), "3a1b2a")
        self.assertEqual(Simplicite.RLE("aAa"), "1a1A1a")
        self.assertEqual(Simplicite.RLE("WWWWWWWWWWWWW"), "9W4W")

    def test_RLE_recursive(self):
        try:
            self.assertEqual(Simplicite.RLE_recursif("", 1), "") # Test failed
            self.assertEqual(Simplicite.RLE_recursif("", 3), "") # Test failed

            self.assertEqual(Simplicite.RLE_recursif("abc", 1), "1a1b1c")
            self.assertEqual(Simplicite.RLE_recursif("abbccc", 1), "1a2b3c")
            self.assertEqual(Simplicite.RLE_recursif("aaabaa", 1), "3a1b2a")
            self.assertEqual(Simplicite.RLE_recursif("aAa", 1), "1a1A1a")

            self.assertEqual(Simplicite.RLE_recursif("abc", 2), "111a111b111c")
            self.assertEqual(Simplicite.RLE_recursif("abc", 3), "311a311b311c")

            saeIte20 = "1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211S1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211E1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211 1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211l1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211g1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211o"
            self.assertEqual(Simplicite.RLE_recursif("SAE Algo", 20), saeIte20)
        except Exception as e:
            self.fail(f"Unexpected exception: {e}")

    def test_unRLE(self):
        try:
            self.assertEqual(Simplicite.unRLE(""), "")
            self.assertEqual(Simplicite.unRLE("1a1b1c"), "abc")
            self.assertEqual(Simplicite.unRLE("1a2b3c"), "abbccc")
            self.assertEqual(Simplicite.unRLE("3a1b2a"), "aaabaa")
            self.assertEqual(Simplicite.unRLE("1a1A1a"), "aAa")
            self.assertEqual(Simplicite.unRLE("9W4W"), "WWWWWWWWWWWWW")
        except Exception as e:
            self.fail(f"Unexpected exception: {e}")

    def test_unRLE_recursive(self):
        try:
            self.assertEqual(Simplicite.unRLE_recursif("", 1), "")
            self.assertEqual(Simplicite.unRLE_recursif("", 3), "")

            self.assertEqual(Simplicite.unRLE_recursif("1a1b1c", 1), "abc")
            self.assertEqual(Simplicite.unRLE_recursif("1a2b3c", 1), "abbccc")
            self.assertEqual(Simplicite.unRLE_recursif("3a1b2a", 1), "aaabaa")
            self.assertEqual(Simplicite.unRLE_recursif("1a1A1a", 1), "aAa")

            self.assertEqual(Simplicite.unRLE_recursif("111a111b111c", 2), "abc")
            self.assertEqual(Simplicite.unRLE_recursif("311a311b311c", 3), "abc")
        except Exception as e:
            self.fail(f"Unexpected exception: {e}")

    def test_RLE_recursive_it50(self):
        try:
            resultat = ""
            self.assertEqual(0, 0)
        except Exception as e:
            self.fail(f"Unexpected exception: {e}")


if __name__ == '__main__':
    unittest.main()
    
# 2 tests failed