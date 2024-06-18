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
        chaine = RLE(chaine)
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
        resultat = unRLE(resultat)
    return resultat