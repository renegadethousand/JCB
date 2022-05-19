package academy.kovalevskyi.codingbootcamp.week0.day3;

public class JavaEntryChallenge {
  
  public static void main(String[] args) {
    printHello();
    System.out.println("Sum of two number: " + sumOfTwoNumbers(3, 2));
    System.out.println("Sum of two number: " + sumOfTwoNumbers(-3, 2));
    System.out.println("Sum of two number: " + sumOfTwoNumbers(0, 100));
    System.out.println("Convert min to sec: " + convertMinToSec(5));
    System.out.println("Convert min to sec: " + convertMinToSec(3));
    System.out.println("Convert min to sec: " + convertMinToSec(2));
    compareTwoNumbers(3, 2);
    compareTwoNumbers(-3, 2);
    compareTwoNumbers(5, 5);
    concatTwoStrings("Sponge", "Bob");
    concatTwoStrings("Kovalevskyi", "Viacheslav");
    System.out.println("Remainder: " + remainder(3, 3));
    System.out.println("Remainder: " + remainder(27, 4));
    System.out.println("Remainder: " + remainder(-15, 7));
    System.out.println("Divisible by 5: " + divisibleBy5(5));
    System.out.println("Divisible by 5: " + divisibleBy5(23));
    System.out.println("Divisible by 5: " + divisibleBy5(-25));
    System.out.println("Divisible by 5: " + divisibleBy5(37));
    System.out.println("First element of array: " + firstElementOfArray(new int[]{1, 2, 3, 4, 5}));
    System.out.println("First element of array: " + firstElementOfArray(new int[]{9999}));
    System.out.println("Smallest element: " + smallestElementOfArray(new int[]{3, 2, -1}));
    System.out.println("Smallest element: " + smallestElementOfArray(new int[]{100, 10, 1000}));
    checkResultOfWork(true, true, false);
    checkResultOfWork(false, true, true);
    checkResultOfWork(true, true, true);
  }

  public static void printHello() {
    System.out.println("Hello World");
  }

  public static int sumOfTwoNumbers(int a, int b) {
    return a + b;
  }
  
  public static int convertMinToSec(int minutes) {
    return minutes * 60;
  }

  public static void compareTwoNumbers(int a, int b) {
    if (a > b) {
      System.out.print("Result: a is bigger");
    } else if (b > a) {
      System.out.print("Result: b is bigger");
    } else {
      System.out.print("Result: numbers are equal");
    }
  }

  public static void concatTwoStrings(String firstName, String lastName) {
    System.out.print(firstName + " " + lastName);
  }

  public static int remainder(int a, int b) {
    return a % b;
  }

  public static boolean divisibleBy5(int num) {
    return num % 5 == 0;
  }

  public static int firstElementOfArray(int[] arr) {
    return arr[0];
  }

  public static int smallestElementOfArray(int[] arr) {
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    return min;
  }
  
  public static void checkResultOfWork(boolean quick, boolean efficient, boolean reliable) {
    if (efficient && quick && reliable) {
      System.out.print("Result of work: excellent, but you are dreaming");
    } else if (quick && reliable) {
      System.out.print("Result of work: poor, but fast enough");
    } else if (efficient && reliable) {
      System.out.print("Result of work: good, but tired of waiting");
    } else if (efficient && quick) {
      System.out.print("Result of work: excellent, but pricey");
    } else {
      System.out.print("Pick at least two");
    }
  } 
}
