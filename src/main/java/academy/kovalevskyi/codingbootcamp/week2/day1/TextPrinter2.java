package academy.kovalevskyi.codingbootcamp.week2.day1;

public class TextPrinter2 {

  public static void main(String[] args) {
    if (args.length != 2) { 
      System.out.println("Please provide 2 input arguments, current amount: " + args.length);
      return;
    }
    if (args[0].length() > 1) {
      System.out.println("First arguments length should be 0 or 1, now it is: " + args[0].length());
      return;
    }
    char side = '\u0000';
    if (args[0].length() > 0) {
      side = args[0].charAt(0);
    }
    if (side == '\u0000') {
      System.out.print("\n " + args[1] + " \n\n");
      return;
    }
    if (side == '\u0000') {
      System.out.println("\n " + args[1] + " \n\n");
      return;
    }
    char[] text = args[1].toCharArray();
    int size = text.length + 4;
    char[][] chars = BoxGeneratorUtils.generateBox(side, size, 3, text);
    BoxGeneratorUtils.print(chars);
  }
}

