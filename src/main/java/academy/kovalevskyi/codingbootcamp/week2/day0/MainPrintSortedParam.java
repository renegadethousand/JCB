
package academy.kovalevskyi.codingbootcamp.week2.day0;

public class MainPrintSortedParam {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify at least one argument!");
      return;
    }
    for (int i = 0; i < args.length - 1; i++) {
      for (int y = 0; y < args.length - i - 1; y++) {
        if (args[y].compareTo(args[y + 1]) > 0) {
          String temp = args[y];
          args[y] = args[y + 1];
          args[y + 1] = temp;
        }
      }
    }
    MainPrintParam.main(args);
  }
}

