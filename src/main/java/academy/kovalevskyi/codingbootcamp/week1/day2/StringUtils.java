package academy.kovalevskyi.codingbootcamp.week1.day2;

public class StringUtils {

  public static boolean isAsciiUppercase(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    for (char i = 'A'; i <= 'Z'; i++) {
      if (ch == i) {
        return true;
      }
    }
    return false;
  }

  public static boolean isAsciiLowercase(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    for (char i = 'a'; i <= 'z'; i++) {
      if (ch == i) {
        return true;
      }
    }
    return false;
  }

  public static boolean isAsciiNumeric(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    for (char i = '0'; i <= '9'; i++) {
      if (ch == i) {
        return true;
      }
    }
    return false;
  }

  public static boolean isAsciiAlphabetic(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    if (isAsciiUppercase(ch) || isAsciiLowercase(ch)) {
      return true;
    }
    return false;
  }

  public static char toAsciiUppercase(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    if (isAsciiLowercase(ch)) {
      ch = (char) (ch - 32);
    }
    return ch;
  }

  public static char toAsciiLowercase(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    if (isAsciiUppercase(ch)) {
      ch = (char) (ch + 32);
    }
    return ch;
  }

  public static StringBuilder makeUppercase(char[] input) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      if (input[i] > 255) {
        throw new IllegalArgumentException();
      }
      if (isAsciiLowercase(input[i])) {
        stringBuilder.append((char) (input[i] - 32));
      } else {
        stringBuilder.append(input[i]);
      }
    }
    return stringBuilder;
  }

  public static StringBuilder makeLowercase(char[] input) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      if (input[i] > 255) {
        throw new IllegalArgumentException();
      }
      if (isAsciiUppercase(input[i])) {
        stringBuilder.append((char) (input[i] + 32));
      } else {
        stringBuilder.append(input[i]);
      }
    }
    return stringBuilder;
  }

  public static StringBuilder makeCamel(char[] input) {
    StringBuilder stringBuilder = new StringBuilder();
    boolean lowerCase = true;
    for (int i = 0; i < input.length; i++) {
      if (input[i] > 255) {
        throw new IllegalArgumentException();
      }
      if (isAsciiAlphabetic(input[i])) {
        if (lowerCase && isAsciiUppercase(input[i])) {
          stringBuilder.append((char) (input[i] + 32));
        } else if (!lowerCase && isAsciiLowercase(input[i])) {
          stringBuilder.append((char) (input[i] - 32));
        } else {
          stringBuilder.append(input[i]);
        }
      } else {
        stringBuilder.append(input[i]);
      }
      lowerCase = !lowerCase;
    }
    return stringBuilder;
  }

  public static boolean isStringAlphaNumerical(char[] input) {
    for (int i = 0; i < input.length; i++) {
      if (!isAsciiAlphabetic(input[i]) && !isAsciiNumeric(input[i]) && input[i] != ' ') {
        return false;
      }
    }
    return true;
  }

  public static char[] concatStrings(char[]... input) {
    int size = 0;
    for (int i = 0; i < input.length; i++) {
      size += input[i].length;
    }
    char[] newBase = new char[size];
    int count = 0;
    for (int i = 0; i < input.length; i++) {
      for (int y = 0; y < input[i].length; y++) {
        if (input[i][y] > 255) {
          throw new IllegalArgumentException();
        }
        newBase[count] = input[i][y];
        count++;
      }
    }
    return newBase;
  }
  
  public static int toInt(char[] input) {
    if (input == null) {
      throw new NullPointerException();
    } else if (input.length == 0) {
      throw new IllegalArgumentException();
    }
    boolean isNegative = (input[0] == '-');
    int size = input.length - (isNegative ? 1 : 0);
    int result = 0;
    for (int i = (isNegative ? 1 : 0); i < input.length; i++) {
      if (isAsciiNumeric(input[i])) {
        int number = input[i] - '0';
        for (int y = 1; y < size; y++) {
          number *= 10;
        }
        size--;
        result += number;
      } else {
        throw new NumberFormatException();
      }
    }
    return result * (isNegative ? -1 : 1);
  }
}
