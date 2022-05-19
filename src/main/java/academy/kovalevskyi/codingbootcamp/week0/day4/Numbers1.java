package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Numbers1 {

  public static void main(String[] args) {
    System.out.println(convertToCharArray(-100));
  }

  public static int[] generateNumbers() {
    int[] nums = new int[100];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }
    return nums;
  }

  public static int findBiggest(int left, int right) {
    if (left > right) {
      return left;
    }
    return right;
  }

  public static int findBiggest(int left, int mid, int right) {
    int firstMax = findBiggest(left, mid);
    int secondMax = findBiggest(mid, right);
    return findBiggest(firstMax, secondMax);
  }

  public static int findBiggest(int[] numbers) {
    int max = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      if (max < numbers[i]) {
        max = numbers[i];
      }
    }
    return max;
  }

  public static int findIndexOfBiggestNumber(int[] numbers) {
    int max = findBiggest(numbers);
    int indexMaxNumber = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (max == numbers[i]) {
        indexMaxNumber = i;
        break;
      }
    }
    return indexMaxNumber;
  }

  public static boolean isNegative(int number) {
    return number < 0;
  }

  public static char[] convertToCharArray(int number) {
    int length = 1;
    int tempNumber = number;
    boolean isNegativeNumber = isNegative(number);
    while (isNegativeNumber ? tempNumber <= -10 : tempNumber >= 10) {
      tempNumber = tempNumber / 10;
      length++; 
    }
  
    length += isNegativeNumber ? 1 : 0;

    char[] chars = new char[length];

    for (int i = length - 1; i >= 0; i--) {
      chars[i] = (char) (number % 10 * (isNegativeNumber ? -1 : 1) + '0');
      number /= 10;
    }    
    if (isNegativeNumber) {
      chars[0] = '-';
    } 
    return chars;  
  }
}

