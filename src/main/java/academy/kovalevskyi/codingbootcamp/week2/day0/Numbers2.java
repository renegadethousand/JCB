
package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week0.day4.Numbers1;
import academy.kovalevskyi.codingbootcamp.week1.day0.NumberUtils;

public class Numbers2 {

  public static void main(String[] args) {
    generateTuples(2);
  }

  public static char[][] generateTriplets() {
    long factorial = NumberUtils.getFactorial(9);
    char[][] result = new char[120][3];
    int count = 0;
    for (char i = '0'; i <= '9'; i++) {
      for (char y = '0'; y <= '9'; y++) {
        for (char k = '0'; k <= '9'; k++) {
          if (i == y || y == k || k == i) {
            continue;
          }
          char[] charCombination1 = new char[]{i, y, k};
          char[] charCombination2 = new char[]{i, k, y};
          char[] charCombination3 = new char[]{k, i, y};
          char[] charCombination4 = new char[]{k, y, i};
          char[] charCombination5 = new char[]{y, k, i};
          char[] charCombination6 = new char[]{y, i, k};
          boolean find = false;
          for (int j = 0; j < result.length; j++) {
            if ((result[j][0] == charCombination1[0]
                && result[j][1] == charCombination1[1]
                && result[j][2] == charCombination1[2])
                || (result[j][0] == charCombination2[0]
                && result[j][1] == charCombination2[1]
                && result[j][2] == charCombination2[2])
                || (result[j][0] == charCombination3[0]
                && result[j][1] == charCombination3[1]
                && result[j][2] == charCombination3[2])
                || (result[j][0] == charCombination4[0]
                && result[j][1] == charCombination4[1]
                && result[j][2] == charCombination4[2])
                || (result[j][0] == charCombination5[0]
                && result[j][1] == charCombination5[1]
                && result[j][2] == charCombination5[2])
                || (result[j][0] == charCombination6[0]
                && result[j][1] == charCombination6[1]
                && result[j][2] == charCombination6[2])
            ) {
              find = true;
              break;
            }
          }
          if (!find) {
            result[count][0] = i;
            result[count][1] = y;
            result[count][2] = k;
            System.out.println(i + " " + y + " " + k);
            count++;
          }
        }
      }
    }
    return result;
  }

  public static char[][] generateTuples() {
    char[][] result = new char[10000][5];
    int count = 0;
    for (char i = '0'; i <= '9'; i++) {
      for (char y = '0'; y <= '9'; y++) {
        for (char j = '0'; j <= '9'; j++) {
          for (char k = '0'; k <= '9'; k++) {
            result[count][0] = i;
            result[count][1] = y;
            result[count][2] = ' ';
            result[count][3] = j;
            result[count][4] = k;
            System.out.println(i + "" + y + "" + "" + j + k);
            count++;
          }
        }
      }
    }
    return result;
  }

  public static char[][] generateTuples(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    } else if (amount == 0) {
      return new char[][]{};
    }
    int temp = amount;
    int max = 1;
    while (temp > 0) {
      max *= 10;
      temp--;
    }
    char[][] result = new char[max][amount];
    int count = 0;
    for (int i = 0; i < max; i++) {
      char[] chars = Numbers1.convertToCharArray(i);
      for (int y = 0; y < amount - chars.length; y++) {
        result[count][y] = '0';
      }
      int startPosition = amount - chars.length;
      for (int y = 0; y < chars.length; y++) {
        result[count][startPosition++] = chars[y];
      }
      count++;
    }
    return result;
  }
}

