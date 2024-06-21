#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

char* RLE(const char* chaine) {
    if (chaine == NULL || strlen(chaine) == 0) {
        return "";
    }

    int len = strlen(chaine);
    char* resultat = (char*)malloc(len * 2 + 1);
    int index = 0;
    int cpt = 1;
    char premierCaractere = chaine[0];

    for (int i = 1; i < len; i++) {
        if (chaine[i] == premierCaractere) {
            cpt++;
            if (cpt == 9) {
                index += sprintf(&resultat[index], "%d%c", cpt, premierCaractere);
                cpt = 0;
            }
        } else {
            if (cpt > 0) {
                index += sprintf(&resultat[index], "%d%c", cpt, premierCaractere);
            }
            premierCaractere = chaine[i];
            cpt = 1;
        }
    }

    if (cpt > 0) {
        sprintf(&resultat[index], "%d%c", cpt, premierCaractere);
    }

    return resultat;
}

char* unRLE(const char* chaine) {
    if (chaine == NULL || strlen(chaine) == 0) {
        return "";
    }

    int len = strlen(chaine);
    char* resultat = (char*)malloc(len * 9 + 1);
    int index = 0;
    int i = 0;

    while (i < len) {
        if (isdigit(chaine[i])) {
            int nombre = chaine[i] - '0';
            char caractereSuivant = chaine[i + 1];
            for (int j = 0; j < nombre; j++) {
                resultat[index++] = caractereSuivant;
            }
            i += 2;
        } else {
            resultat[index++] = chaine[i];
            i++;
        }
    }

    resultat[index] = '\0';
    return resultat;
}

char* RLE_Recursif(const char* chaine, int iteration) {
    char* resultat = strdup(chaine);
    for (int i = 0; i < iteration; i++) {
        char* temp = RLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}

char* unRLE_Recursif(const char* chaine, int iteration) {
    char* resultat = strdup(chaine);
    for (int i = 0; i < iteration; i++) {
        char* temp = unRLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}



void assertEqualStrings(const char *expected, const char *actual, const char *message) {
    if (strcmp(expected, actual) == 0) {
        printf("[PASS] %s\n", message);
    } else {
        printf("[FAIL] %s - Expected: \"%s\", Actual: \"%s\"\n", message, expected, actual);
    }
}

int main() {
    assertEqualStrings("", RLE(""), "RLE(\"\")=\"\"");
    assertEqualStrings("1a1b1c", RLE("abc"), "RLE(\"abc\")=\"1a1b1c\"");
    assertEqualStrings("1a2b3c", RLE("abbccc"), "RLE(\"abbccc\")=\"1a2b3c\"");
    assertEqualStrings("3a1b2a", RLE("aaabaa"), "RLE(\"aaabaa\")=\"3a1b2a\"");
    assertEqualStrings("1a1A1a", RLE("aAa"), "RLE(\"aAa\")=\"1a1A1a\"");
    assertEqualStrings("9W4W", RLE("WWWWWWWWWWWWW"), "RLE(\"WWWWWWWWWWWWW\")=\"9W4W\"");

    assertEqualStrings("", unRLE(""), "unRLE(\"\")=\"\"");
    assertEqualStrings("abc", unRLE("1a1b1c"), "unRLE(\"1a1b1c\")=\"abc\"");
    assertEqualStrings("abbccc", unRLE("1a2b3c"), "unRLE(\"1a2b3c\")=\"abbccc\"");
    assertEqualStrings("aaabaa", unRLE("3a1b2a"), "unRLE(\"3a1b2a\")=\"aaabaa\"");
    assertEqualStrings("aAa", unRLE("1a1A1a"), "unRLE(\"1a1A1a\")=\"aAa\"");
    assertEqualStrings("WWWWWWWWWWWWW", unRLE("9W4W"), "unRLE(\"9W4W\")=\"WWWWWWWWWWWWW\"");

    char input[] = "abc";
    assertEqualStrings("1a1b1c", RLE_Recursif(input, 1), "RLE_Recursif(\"abc\", 1)=\"1a1b1c\"");
    assertEqualStrings("111a111b111c", RLE_Recursif(input, 2), "RLE_Recursif(\"abc\", 2)=\"111a111b111c\"");
    assertEqualStrings("311a311b311c", RLE_Recursif(input, 3), "RLE_Recursif(\"abc\", 3)=\"311a311b311c\"");

    assertEqualStrings("abc", unRLE_Recursif("1a1b1c", 1), "unRLE_Recursif(\"1a1b1c\", 1)=\"abc\"");
    assertEqualStrings("abc", unRLE_Recursif("111a111b111c", 2), "unRLE_Recursif(\"111a111b111c\", 2)=\"abc\"");
    assertEqualStrings("abc", unRLE_Recursif("311a311b311c", 3), "unRLE_Recursif(\"311a311b311c\", 3)=\"abc\"");

    return 0;
}
