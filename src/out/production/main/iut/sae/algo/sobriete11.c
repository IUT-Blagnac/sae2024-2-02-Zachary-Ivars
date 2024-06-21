#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *RLE(const char *in) {
  if (in == NULL || in[0] == '\0') {
    printf("Tableau vide \n");
    exit(1);
  }

  int length = strlen(in);
  char *stringReturn = malloc((2 * length + 1) * sizeof(char));
  stringReturn[0] = '\0';
  int pos = 0;

  char charSelect = in[0];
  int nbChar = 1;

  for (int i = 1; i <= length; i++) {
    if (i < length && in[i] == charSelect) {
      nbChar++;
    } else {
      pos += sprintf(stringReturn + pos, "%d%c", nbChar, charSelect);
      if (i < length) {
        charSelect = in[i];
        nbChar = 1;
      }
    }
  }

  return stringReturn;
}

char *unRLE(const char *in) {
  if (in == NULL || in[0] == '\0') {
    printf("Tableau vide \n");
    exit(1);
  }

  int length = strlen(in);
  char *stringReturn = malloc((length + 1) * sizeof(char));
  stringReturn[0] = '\0';
  int pos = 0;

  for (int i = 0; i < length; i += 2) {
    int count = in[i] - '0';
    char charToRepeat = in[i + 1];

    for (int j = 0; j < count; j++) {
      stringReturn[pos++] = charToRepeat;
    }
  }

  stringReturn[pos] = '\0';

  return stringReturn;
}

char *RLE_it(char *in, int iteration) {
  if (iteration < 1) {
    printf("Impossible d'avoir une iteration < 1\n");
    exit(1);
  }

  char *copie = strdup(in);

  while (iteration > 0) {
    char *pro = RLE(copie);
    free(copie);
    copie = pro;
    iteration--;
  }

  return copie;
}

char *unRLE_it(char *in, int iteration) {
  if (iteration < 1) {
    printf("Impossible d'avoir une iteration < 1\n");
    exit(1);
  }

  char *copie = strdup(in);

  while (iteration > 0) {
    char *pro = unRLE(copie);
    free(copie);
    copie = pro;
    iteration--;
  }

  return copie;
}

// Les tests :
char *RLE(const char *in);
char *unRLE(const char *in);
char *RLE_it(char *in, int iteration);
char *unRLE_it(char *in, int iteration);


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
    assertEqualStrings("1a1b1c", RLE_it(input, 1), "RLE_it(\"abc\", 1)=\"1a1b1c\"");
    assertEqualStrings("111a111b111c", RLE_it(input, 2), "RLE_it(\"abc\", 2)=\"111a111b111c\"");
    assertEqualStrings("311a311b311c", RLE_it(input, 3), "RLE_it(\"abc\", 3)=\"311a311b311c\"");

    assertEqualStrings("abc", unRLE_it("1a1b1c", 1), "unRLE_it(\"1a1b1c\", 1)=\"abc\"");
    assertEqualStrings("abc", unRLE_it("111a111b111c", 2), "unRLE_it(\"111a111b111c\", 2)=\"abc\"");
    assertEqualStrings("abc", unRLE_it("311a311b311c", 3), "unRLE_it(\"311a311b311c\", 3)=\"abc\"");

    return 0;
}

// tous les tests sont passés avec succès