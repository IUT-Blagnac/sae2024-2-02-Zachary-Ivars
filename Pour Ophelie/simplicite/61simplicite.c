#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* RLE(char* text) {
    // on initialise la première lettre et le compteur
    char lettre = text[0];
    char* chaineFinale = (char*)malloc(strlen(text) * 2 + 1);
    int compteurLettre = 0;
    int indexChaineFinale = 0;

    // on parcours chaque caractère de la chaîne
    for (int i = 0; i < strlen(text); i++) {
        // si le caractère actuel est le même que le précédent et que le compteur est inférieur à 9
        if (lettre == text[i] && compteurLettre < 9) {
            compteurLettre++;
        } else {
            // on ajoute le compteur et la lettre à la chaîne finale
            sprintf(chaineFinale + indexChaineFinale, "%d%c", compteurLettre, lettre);
            indexChaineFinale += 2; // on augmente l'index de 2 pour écrire le prochain caractère à la bonne place (parce que a chaque fois on ajoute 2 caractères)
            compteurLettre = 1;
            // on mets à jour la lettre
            lettre = text[i];
        }

        // si le compteur atteint 9 (ce qu'il ne faut pas)
        if (compteurLettre == 9) {
            // on ajoute le compteur et la lettre à la chaîne finale
            sprintf(chaineFinale + indexChaineFinale, "%d%c", compteurLettre, lettre);
            indexChaineFinale += 2;
            // si on n'est pas à la fin de la chaîne
            if (i < strlen(text) - 1) {
                // on mets à jour la lettre
                lettre = text[i + 1];
            }
            // on reinitialise le compteur
            compteurLettre = 0;
        }
    }

    // si le compteur est supérieur à 0 à la fin de la boucle
    if (compteurLettre > 0) {
        // on ajoute ce qu'il reste au resultat
        sprintf(chaineFinale + indexChaineFinale, "%d%c", compteurLettre, lettre);
    }

    // on retourne la chaine finale
    return chaineFinale;
}

char* RLE_recursif(const char* chaine, int nombre) {
    char* resultat = strdup(chaine);
    for (int i = 0; i < nombre; i++) {
        char* temp = RLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}



char* unRLE(const char* chaine) {
    int length = strlen(chaine);
    char* result = malloc(length * sizeof(char));
    int index = 0;

    for (int i = 0; i < length; i += 2) {
        int nombre = chaine[i] - '0';
        char caractere = chaine[i + 1];

        for (int j = 0; j < nombre; j++) {
            result[index++] = caractere;
        }
    }
    result[index] = '\0';  // Null-terminate the string
    return result;
}

char* unRLE_recursif(const char* chaine, int nombre) {
    char* resultat = strdup(chaine);

    for (int i = 0; i < nombre; i++) {
        char* temp = unRLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}