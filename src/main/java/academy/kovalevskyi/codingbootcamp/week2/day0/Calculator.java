
package academy.kovalevskyi.codingbootcamp.week2.day0;

public class Calculator {

  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Please provide 3 input arguments, example: 2 + 3");
    } else {
      long a;
      long b;
      String operation = args[1];
      if (!operation.equals("+")
          && !operation.equals("-")
          && !operation.equals("/")
          && !operation.equals("%")
          && !operation.equals("*")) {
        throw new IllegalArgumentException();
      }
      try {
        a = Long.parseLong(args[0]);
        b = Long.parseLong(args[2]);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException();
      }
      if (b == 0 && (operation.equals("/") || operation.equals("%"))) {
        System.out.println("Division by zero is impossible!");
      } else {
        Number result = switch (operation) {
          case "+" -> a + b;
          case "-" -> a - b;
          case "*" -> a * b;
          case "/" -> (double) a / b;
          case "%" -> a % b;
          default -> throw new IllegalArgumentException();
        };
        System.out.println("result: " + result);
      }
    }
  }
}

