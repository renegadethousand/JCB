package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Alphabet {

  public static char[] generateAlphabet() {
    char[] charArray = new char[26];
    char startChar = 'a';
    for (int i = 0; i < 26; i++) {
      charArray[i] = (char) (startChar + i);
    }
    return charArray;
  }

  public static char[] generateReversedAlphabet() {
    char[] charArray = new char[26];
    char startChar = 'z';
    for (int i = 0; i < 26; i++) {
      charArray[i] = (char) (startChar - i);
    }
    return charArray;
  }
}

