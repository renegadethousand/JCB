package academy.kovalevskyi.codingbootcamp.week1.day0;

public class NumberUtils {

  public static long getFactorial(final int number) {
    if (number < 0 || number > 20) {
      throw new IllegalArgumentException();
    }
    long result = 1;
    for (int i = 1; i <= number; i++) {
      result *= i;
    }
    return result;
  }

  public static long factorialRecursive(int number) {
    if (number < 0 || number > 20) {
      throw new IllegalArgumentException();
    }
    if (number == 0) {
      return 1;
    }
    if (number <= 2) {
      return number;
    }
    return number * factorialRecursive(number - 1);
  }

  public static double power(int base, int power) {
    if (power == 0) {
      return 1;
    }

    boolean isNegative = false;
    if (power < 0) {
      isNegative = true;
      power = -power;
    }

    double result = 1;
    for (int i = 1; i <= power; i++) {
      result *= base;
    }

    return isNegative ? 1 / result : result;
  }
  
  public static double powerRecursive(int base, int power) {
    if (power == 0) {
      return 1;
    }
    boolean isNegative = false;
    if (power < 0) {
      isNegative = true;
      power *= -1;
    } 
    double result = (double) base * powerRecursive(base, power - 1);
    return isNegative ? 1 / result : result;    
  }

  public static int fibRecursive(int index) {
    if (index < 0) {
      throw new IllegalArgumentException();
    }
    if (index == 0 || index == 1) {
      return index;
    }
    return fibRecursive(index - 1) + fibRecursive(index - 2);
  }

  public static int[] fibSequence(int length) {
    if (length < 0) {
      throw new IllegalArgumentException();
    } else if (length == 0) {
      return new int[]{};
    } else if (length == 1) {
      return new int[]{0};
    }
    int[] fibArray = new int[length];
    fibArray[0] = 0;
    fibArray[1] = 1;

    for (int i = 2; i < length; i++) {
      fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
    }
    return fibArray;
  }

  public static int sqrt(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    double temp;
    double sr = target / 2;
    do {
      temp = sr;
      sr = (temp + (target / temp)) / 2;
    } while ((temp - sr) != 0);
    
    if (sr % 1 != 0) {
      return -1;
    }
    return (int) sr;
  }

  public static boolean isPrime(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    if (target <= 1) {
      return false;
    }
    for (int i = 2; i < target; i++) {
      if (target % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static int findNextPrime(int target) {
    while (!isPrime(target)) {
      target++;
    }
    return target;
  }

  public static void sort(int[] target) {
    if (target == null) {
      return;
    }
    for (int i = 0; i < target.length - 1; i++) {
      boolean sorted = true;
      for (int y = 0; y < target.length - i - 1; y++) {
        if (target[y] > target[y + 1]) {
          int temp = target[y];
          target[y] = target[y + 1];
          target[y + 1] = temp;
          sorted = false;
        }
      }
      if (sorted) {
        break;
      }
    }
  }
}

